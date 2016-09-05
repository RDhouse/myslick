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
            if(location.x > 0) {
                // TODO: adjust acceleration.
                acceleration.x += -0.01f;
            }
        }
        if (input.isKeyDown(Input.KEY_D)) {
            if (location.x + getWidth() < NewBreak.GAME_WIDTH ) {
                // TODO: adjust acceleration.
                acceleration.x += 0.01f;
            }
        }

        velocity.add(acceleration);
        acceleration.scale(0);
        location.add(velocity);
    }
}
