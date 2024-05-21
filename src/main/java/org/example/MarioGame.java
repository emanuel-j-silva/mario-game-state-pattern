package org.example;

import org.example.State.Dead;
import org.example.State.Small;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarioGame {
    private MarioState state = new Small(this);
    private int score;
    private List<String> logGame = new ArrayList();
    private String lastEvent;
    private String lastState;

    public MarioGame(){}
    public void takeMysteryBox(){
        Random random = new Random();
        int value = random.nextInt(4);
        switch (value){
            case 0:
                this.takeMushroom();
                break;
            case 1:
                this.takeFlower();
                break;
            case 2:
                this.takeFeather();
                break;
            case 3:
                this.takeDamage();
                break;
            default:
                break;
        }
    }

    public boolean isDone(){
        String dead = Dead.class.getSimpleName();
        return this.state.getClass().getSimpleName() == dead;
    }

    public void takeMushroom(){
        this.lastEvent = "Take mushroom";
        this.lastState = this.state.getClass().getSimpleName();
        this.state.takeMushroom();
        this.registerEvent();
    }
    public void takeFlower(){
        this.lastEvent = "Take flower";
        this.lastState = this.state.getClass().getSimpleName();
        this.state.takeFlower();
        this.registerEvent();
    }
    public void takeFeather(){
        this.lastEvent = "Take feather";
        this.lastState = this.state.getClass().getSimpleName();
        this.state.takeFeather();
        this.registerEvent();
    }
    public void takeDamage(){
        this.lastEvent = "Take damage";
        this.lastState = this.state.getClass().getSimpleName();
        this.state.takeDamage();
        this.registerEvent();
    }
    public void registerEvent(){
        String event = this.lastEvent;
        String actualState = this.state.getClass().getSimpleName();
        String score = Integer.toString(this.getScore());
        String register = String.format(" %s | %s => %s | %s",
                event,this.lastState,actualState,score);

        this.logGame.add(register);
    }
    public void setState(MarioState state) {
        this.state = state;
    }

    public void incrementScore(){
        this.score += 1000;
    }

    public void resetGame() {
        this.state = new Small(this);
        this.score = 0;
        this.logGame.clear();
    }


    public int getScore() {
        return score;
    }

    public List<String> getLogGame() {
        return logGame;
    }
}
