package com.rdhouse.newbreak;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class Player extends Entity {

    private Input input;

    public Player(Image image, Input input) {
        super(image);
        this.input = input;
    }

    public void update() {
        // Controls
        if (input.isKeyDown(Input.KEY_A)) {
            if(getPosition().getX() > 0) {
                getPosition().sub(getSpeed());
            }
        }
        if (input.isKeyDown(Input.KEY_D)) {
            if (getPosition().getX() + getWidth() < NewBreak.GAME_WIDTH ) {
                getPosition().add(getSpeed());
            }
        }
    }
}
