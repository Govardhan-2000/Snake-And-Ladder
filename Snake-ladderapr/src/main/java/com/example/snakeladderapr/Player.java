package com.example.snakeladderapr;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle Coin;
    private int currentPosition;
    private String name;
   private static Board gameBoard= new Board();


    public Player(int tileSize, Color coinColor, String PlayerName){
        Coin =new Circle(tileSize/2);
        Coin.setFill(coinColor);
        currentPosition=0;
        MovePlayer(1);
        name = PlayerName;
    }
    public void MovePlayer(int diceValue){
        if(currentPosition+diceValue<=100){
            currentPosition += diceValue;
            TranslateTransition secondMove= null,firstMove = tranSlateAnimation(diceValue);
            tranSlateAnimation(diceValue);

            int newPosition = gameBoard.getNewPosition(currentPosition);
            if(newPosition!=currentPosition && newPosition!= -1){
                currentPosition = newPosition;
                secondMove=tranSlateAnimation(6);
            }
            if(secondMove==null){
                firstMove.play();
            }
            else{
                SequentialTransition sequentialTransition = new SequentialTransition(firstMove,
                        new PauseTransition(Duration.millis(1000)),secondMove);
                sequentialTransition.play();

            }

        }

//        int x= gameBoard.getXCoordinate(currentPosition);
//        int y= gameBoard.getYCoordinate(currentPosition);
//        Coin.setTranslateX(x);
//        Coin.setTranslateY(y);

    }

    private TranslateTransition tranSlateAnimation(int diceValue){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),Coin);
        animate.setToX(gameBoard.getXCoordinate(currentPosition));
        animate.setToY(gameBoard.getYCoordinate(currentPosition));
        animate.setAutoReverse(false);
        return animate;
    }
    public void startingPosition(){
        currentPosition = 1;
        MovePlayer(0);
    }
boolean isWinner(){
        if(currentPosition==100)
            return true;
        return false;

}
    public Circle getCoin() {
        return Coin;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
