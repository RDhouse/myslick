package com.rdhouse.mysi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

/**
 * Created by Sir Royal Air Benny on 24-8-2016.
 */
public class Player extends Entity {

    private Animation animation;

    public Player(Image image) {
        super(image);
    }

    public void setAnimation(Image[] images, int duration) {
        animation = new Animation(images, duration);
    }

    public Animation getAnimation() {
        return animation;
    }

    public void render() {
        animation.draw(getX(), getY(), getImage().getWidth() * 2, getImage().getHeight() * 2);
    }
}
