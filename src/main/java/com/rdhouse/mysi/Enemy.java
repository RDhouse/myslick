package com.rdhouse.mysi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

/**
 * Created by Sir Royal Air Benny on 24-8-2016.
 */
public class Enemy extends Entity {

    private Animation animation;
    private boolean isLeft;

    public Enemy(Image image) {
        super(image);
    }

    public void setAnimation(Image[] images, int duration) {
        animation = new Animation(images, duration);
    }

    public Animation getAnimation() {
        return animation;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

}
