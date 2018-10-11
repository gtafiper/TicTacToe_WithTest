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
    
    /**
     * getScoreOne->Draw er den som sender videresender værdien
     * @return 
     */
    @Override
    public int getScoreOne()
    {
        return Player1;
    }
    @Override
    public int getScoreTwo()
    {
        return Player2;
    }
    @Override
    public int getScoreDraw()
    {
        return draw;
    }

    /**
     * Giver et point til vinderne.
     * @param playerno 
     */
    @Override
    public void incrementScore(int playerno)
    {
        switch (getWinner())
        {
            case 1:
                Player1 ++;
                break;
            case 2:
                Player2 ++;
                break;
            case -1:
                draw++;
                break;
        }
          
    }
    
    
}
