package com.rdhouse.newbreak;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class Entity {

    private Image image;

    public Vector2f location;
    public Vector2f velocity;
    public Vector2f acceleration;

    public Entity(Image image) {
        this.image = image;
        location = new Vector2f();
        velocity = new Vector2f();
        acceleration = new Vector2f();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public void render() {
        image.draw(location.x, location.y);
    }

    public void update() {

    }
}
