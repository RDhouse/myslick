package com.rdhouse.natureofcode;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 * Created by Sir Royal Air Benny on 26-8-2016.
 */
public class Ball extends Entity {

    public Ball(Image image) {
        super(image);
    }

    public void update(Input input) {
        System.out.printf("Mouse X: %d.4, Y: %d.4\n", input.getMouseX(), input.getMouseY());

        collisions();

        Vector2 mouse = new Vector2(input.getMouseX(), input.getMouseY());
        Vector2 dir = Vector2.sub(mouse, location);

        dir.normalise();

        dir.mult(0.5f);

        acceleration = dir;

        velocity.add(acceleration);
        velocity.limit(3.5f);
        location.add(velocity);
    }

    private void collisions() {
        if (location.x > App.WIDTH ) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = App.WIDTH;
        }

        if (location.y > App.HEIGHT) {
            location.y = 0;
        } else if (location.y < 0) {
            location.y = App.HEIGHT;
        }
    }
}
