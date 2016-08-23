package com.rdhouse.breakout;

import org.newdawn.slick.Image;

/**
 * Created by rutgerd on 23-8-2016.
 */
public abstract class Entity {
    protected Image image;
    protected int x;
    protected int y;

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
