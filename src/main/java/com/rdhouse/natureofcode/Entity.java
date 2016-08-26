package com.rdhouse.natureofcode;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by Sir Royal Air Benny on 26-8-2016.
 */
public class Entity {

    private Image image;

    Vector2 location = new Vector2();
    Vector2 velocity = new Vector2();
    Vector2 acceleration = new Vector2();

    public Entity(Image image) {
        this.image = image;
    }

    public void render() {
        image.draw(location.x, location.y);
    }
}
