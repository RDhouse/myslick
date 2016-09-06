package com.rdhouse.newbreak;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.RoundedRectangle;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class Brick extends Entity {


    public Brick(Image image) {
        super(image);

    }

    public void update() {
    }

    public void render() {
        getImage().draw(location.x, location.y);
    }

    public RoundedRectangle getBounds() {
        return new RoundedRectangle(location.x, location.y, 32, 32, 4);
    }
}
