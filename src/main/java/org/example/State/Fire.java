package org.example.State;

import org.example.MarioGame;
import org.example.MarioState;

public class Fire implements MarioState {

    private MarioGame mario;

    public Fire(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeMushroom() {
        this.mario.incrementScore();
    }

    @Override
    public void takeFlower() {
        this.mario.incrementScore();
    }

    @Override
    public void takeFeather() {
        Cape newState = new Cape(this.mario);
        this.mario.setState(newState);
    }

    @Override
    public void takeDamage() {
        Big newState = new Big(this.mario);
        this.mario.setState(newState);
    }
}
