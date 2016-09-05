package com.rdhouse.newbreak;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

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
            acceleration.set(-0.05f, 0f);

        }
        if (input.isKeyDown(Input.KEY_D)) {
            acceleration.set(0.05f, 0f);
        }

        if(location.x < 0) {
            // TODO: adjust acceleration.
            velocity.scale(0);
            acceleration.add(new Vector2f(0.5f, 0f));
        }

        if (location.x + getWidth() > NewBreak.GAME_WIDTH ) {
            // TODO: adjust acceleration.
            velocity.scale(0);
            acceleration.add(new Vector2f(-0.5f, 0f));
        }

        velocity.add(acceleration);
        acceleration.scale(0);
        location.add(velocity);
    }
}
