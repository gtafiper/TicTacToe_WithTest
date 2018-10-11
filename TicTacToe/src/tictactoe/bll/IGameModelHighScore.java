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
public interface IGameModelHighScore extends IGameModel
{
    public int getScoreOne();
    public int getScoreTwo();
    public int getScoreDraw();
    public void incrementScore(int playerno);
}
