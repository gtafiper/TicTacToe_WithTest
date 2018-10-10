/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import java.util.Arrays;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
  public int Player = 2;  
  int[][] gameBoard = new int [3][3];  
  public int frieFelter = 9;  
  
   private IGameModelHighScore game;
    /**
     * Returns 1 for player 1, 2 for player 2.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        if (Player == 1)
        {
            Player = 2;
        }
        else  
     
        {
             Player = 1; 
        }
        return Player;
    }
    

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        //TODO Implement this method
        
        if (gameBoard [col][row] == 1 || gameBoard [col][row] == 2)
        {
            return false;
        }
        else
        {
            gameBoard[col][row] = Player;
            frieFelter --;
            return true;
           
        }
        
    }
    //Checks if the game is over 
    public boolean isGameOver()
    {
        //TODO Implement this method
        if(getWinner() == 1 || getWinner() == 2)
        {
            return true;
        }
        if (frieFelter != 0)
        {
            return false;
        }
        else
        {
            return true;
        }
      
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        if (checkVinder() == true)
        {
            return Player;    
        }
        else 
        {
            return -1;
        }
        
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
      for (int[] gameBoard1 : gameBoard)
      {
          Arrays.fill(gameBoard1, 0);
      }
        Player = 2;
        frieFelter = 9;
    }
    

    //returns the player int 
    public int getPlayer() 
    {
        return Player;
    }

    // Checks if there is a winer and if so displays the winner 
    public boolean checkVinder()
    {
      for (int i = 0; i < gameBoard.length; i++)
      {
          if (gameBoard[i][0] == Player && gameBoard[i][1] == Player && gameBoard[i][2] == Player)
          {
              return true;
          }
      }
        for (int i = 0; i < gameBoard.length; i++)
        {
            if (gameBoard [0][i] == Player && gameBoard [1][i] == Player && gameBoard [2][i] == Player )
            {
                return true;
            }
        }
        if (gameBoard [0][0] == Player && gameBoard [1][1] == Player && gameBoard [2][2] == Player )
        {
            return true;
        }
        else if (gameBoard [2][0] == Player && gameBoard [1][1] == Player && gameBoard [0][2] == Player )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
