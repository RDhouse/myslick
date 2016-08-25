package com.rdhouse.newbreak;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class Entity {

    private Image image;

    private Vector2f position;
    private Vector2f speed;

    public Entity(Image image) {
        this.image = image;
        position = new Vector2f();
        speed = new Vector2f();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public Vector2f getSpeed() {
        return speed;
    }

    public void setSpeed(Vector2f speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public void render() {
        image.draw(position.getX(), position.getY());
    }
}
