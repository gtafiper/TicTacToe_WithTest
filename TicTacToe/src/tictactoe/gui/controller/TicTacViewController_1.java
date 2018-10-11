/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tictactoe.bll.GameBoardHighScore;
import tictactoe.bll.IGameModelHighScore;

/**
 *
 * @author Stegger
 */
public class TicTacViewController_1 implements Initializable
{

    private static final String TXT_PLAYER = "Player: ";
    private IGameModelHighScore game;
    
    @FXML
    private Label lblPlayer;
    @FXML
    private Button btnNewGame;
    @FXML
    private GridPane gridPane;
    @FXML
    private Button btnBack;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private BorderPane rootPane2;
    @FXML
    private Label lblPlayer1;
    @FXML
    private Label lblPlayer2;
    @FXML
    private Label lblPlayer1Score;
    @FXML
    private Label lblPlayer2Score;
    @FXML
    private Label lblDraw;
    @FXML
    private Label lblDrawScore;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = game.getPlayer();
            if (game.isGameOver()) {}
            else if (game.play(c, r))
            {
                if (game.isGameOver())
                {
                    
                                        Button btn = (Button) event.getSource();
                    String xOrO = player == 2 ? "O" : "X";
                    btn.setText(xOrO);
                    int winner = game.getWinner();
                    displayWinner(winner);
                    game.incrementScore(winner);
                    getScores();
                }
                else
                {
                    Button btn = (Button) event.getSource();
                    String xOrO = player == 2 ? "O" : "X";
                    btn.setText(xOrO);
                    setPlayer();
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoardHighScore();
        getScores();
        setPlayer();
    }

    private void setPlayer()
            
    {
        lblPlayer.setText(TXT_PLAYER + game.getNextPlayer());
    }

    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        lblPlayer.setText(message);
    }
    
    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }
    
    /**
     * går tilbage til startskærmen
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleButtonBack(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) rootPane2.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/tictactoe/gui/views/MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    /**
     * putter scoren i labels
     */
    private void getScores() {
        lblPlayer1Score.setText(String.valueOf(game.getScoreOne()));
        lblPlayer2Score.setText(String.valueOf(game.getScoreTwo()));
        lblDrawScore.setText(String.valueOf(game.getScoreDraw()));
    }
}
