package org.example;


import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player>{
    private String userName;
    private MarioGame marioGame;
    private List<Integer> gameScores = new ArrayList<>();
    public int highestScore = 0;

    public Player(String userName, MarioGame marioGame) {
        this.userName = userName;
        this.marioGame = marioGame;
    }

    public void addScore(int score){
        this.gameScores.add(score);
    }

    public int record(){
        return this.highestScore;
    }

    public void playGame() throws InterruptedException {
        marioGame.resetGame();
        while (!marioGame.isDone()){
            marioGame.takeMysteryBox();
            System.out.println(marioGame.getLogGame()
                    .get(marioGame.getLogGame().size()-1));
            Thread.sleep(1500);
        }
        this.addScore(marioGame.getScore());
        if (marioGame.getScore() > highestScore){
            highestScore = this.marioGame.getScore();
        }
        System.out.println("\n");
        System.out.println("End game! Scoreboard: " + this.marioGame.getScore());
    }

    public String getUserName() {
        return this.userName;
    }

    @Override
    public int compareTo(Player o) {
        if (this.record() < o.record()) {
            return 1;
        } else {
            return this.record() > o.record() ? -1 : this.userName.compareTo(o.getUserName());
        }
    }
}
