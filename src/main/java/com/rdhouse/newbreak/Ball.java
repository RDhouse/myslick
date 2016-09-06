package com.rdhouse.newbreak;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class Ball extends Entity {

    public Ball(Image image) {
        super(image);
    }

    @Override
    public void render() {
        getImage().draw(location.x, location.y);
    }

    @Override
    public void update() {

        if (location.x < 0 || location.x + getWidth() > NewBreak.GAME_WIDTH) {
            velocity.set(velocity.x * -1, velocity.y);

        }
        if (location.y < 0 || location.y + getHeight() > NewBreak.GAME_HEIGHT) {
            velocity.set(velocity.x , velocity.y * -1);
        }

        velocity.add(acceleration);
        location.add(velocity);
        acceleration.scale(0);
    }

    public Circle getBounds() {
        return new Circle(location.x + 8, location.y + 8, 8);
    }
}
