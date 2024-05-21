package org.example.State;

import org.example.MarioGame;
import org.example.MarioState;

public class Big implements MarioState {
    private MarioGame mario;

    public Big(MarioGame mario) {
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
        Cape newState = new Cape(this.mario);
        this.mario.setState(newState);
    }

    @Override
    public void takeDamage() {
        Small newState = new Small(this.mario);
        this.mario.setState(newState);
    }
}
