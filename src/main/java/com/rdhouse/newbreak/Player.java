package com.rdhouse.newbreak;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 *
 * Friction = -1 * u * N * v.norm
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
            acceleration.add(new Vector2f(-0.35f, 0f));

        }
        if (input.isKeyDown(Input.KEY_D)) {
            acceleration.add(new Vector2f(0.35f, 0f));
        }

        if(location.x < 0) {
            // TODO: adjust acceleration.
            velocity.scale(0);
            acceleration.add(new Vector2f(1.5f, 0f));
        }

        if (location.x + getWidth() > NewBreak.GAME_WIDTH ) {
            // TODO: adjust acceleration.
            velocity.scale(0);
            acceleration.add(new Vector2f(-1.5f, 0f));
        }

        applyFriction();

        velocity.add(acceleration);
        location.add(velocity);

        acceleration.scale(0);
    }

    @Override
    public void render() {
        super.render();
    }

    public RoundedRectangle getBounds() {
        return new RoundedRectangle(location.x, location.y, getWidth() - 3, getHeight() - 4, 16);
    }

    private void applyFriction() {
        float coefficient = 0.01f;
        float normal = 10.0f;
        float frictionMag = coefficient * normal;
        Vector2f friction = velocity.copy();
        friction.scale(-1);
        friction.normalise();
        friction.scale(frictionMag);

        acceleration.add(friction);
    }


}
