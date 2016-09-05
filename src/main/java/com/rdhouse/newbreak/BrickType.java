package com.rdhouse.newbreak;

import org.newdawn.slick.Image;

/**
 * Created by RDHouse on 6-9-2016.
 */
public enum BrickType {

    RED(SpriteLoader.getSprite(0, 0, 35, 35)),
    PURPLE(SpriteLoader.getSprite(40, 0, 35, 35)),
    ORANGE(SpriteLoader.getSprite(80, 0, 35, 35)),
    BRICK_HARD(SpriteLoader.getSprite(320, 0, 35, 35)),
    BRICK_SOFT(SpriteLoader.getSprite(360, 0, 35, 35));

    private Image image;

    BrickType(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}
