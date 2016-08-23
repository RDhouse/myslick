package com.rdhouse.mysi;

import org.newdawn.slick.Image;

/**
 * Created by Sir Royal Air Benny on 23-8-2016.
 */
public class Entity {

    private Image image;
    private int x, y;

    public Entity(Image image) {
        this.image = image;
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

    public Image getImage() {
        return image;
    }
}
