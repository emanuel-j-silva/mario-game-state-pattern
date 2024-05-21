package org.example.State;

import org.example.MarioGame;
import org.example.MarioState;

public class Cape implements MarioState {
    private MarioGame mario;

    public Cape(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeMushroom() {
        this.mario.incrementScore();
    }

    @Override
    public void takeFlower() {
        Fire newState = new Fire(this.mario);
        this.mario.setState(newState);
    }

    @Override
    public void takeFeather() {
        this.mario.incrementScore();
    }

    @Override
    public void takeDamage() {
        Big newState = new Big(this.mario);
        this.mario.setState(newState);
    }
}
