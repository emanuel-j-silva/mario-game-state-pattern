package org.example.State;

import org.example.MarioGame;
import org.example.MarioState;

public class Dead implements MarioState {

    private MarioGame mario;

    public Dead(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeMushroom() {

    }

    @Override
    public void takeFlower() {

    }

    @Override
    public void takeFeather() {

    }

    @Override
    public void takeDamage() {

    }
}
