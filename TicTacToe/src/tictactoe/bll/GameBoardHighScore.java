/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Bruger
 */
public class GameBoardHighScore extends GameBoard implements IGameModelHighScore
{
    private int Player1 = 0;
    private int Player2 = 0;
    private int draw = 0;
    public int score;       
            
    @Override
    public int getScore(int player)
    {
        return Player;
    }

    @Override
    public void incrementScore(int playerno)
    {
        if (Player1 == getWinner())
        {
            Player1 ++;
           
        }
        if (Player2 == getWinner())
        {
            Player2 ++;
           
        }
//        else (frieFelter == getWinner())
//        [
//            draw ++;
//            return true;
//        ]
          
    }
    
}
