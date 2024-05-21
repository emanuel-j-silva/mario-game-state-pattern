package org.example.State;

import org.example.MarioGame;
import org.example.MarioState;

public class Small implements MarioState {
    private MarioGame mario;

    public Small(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeMushroom(){
        Big newState = new Big(this.mario);
        this.mario.setState(newState);
    }

    @Override
    public void takeFlower() {
        Fire newState = new Fire(this.mario);
        this.mario.setState(newState);
    }

    @Override
    public void takeFeather() {
        Cape newstate = new Cape(this.mario);
        this.mario.setState(newstate);
    }

    @Override
    public void takeDamage() {
        Dead newState = new Dead(this.mario);
        this.mario.setState(newState);
    }
}
