package com.rdhouse.newbreak;

import org.newdawn.slick.Image;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class Background {

    private Image image;

    public Background(Image image) {
        this.image = image;
    }

    public void render() {
        image.draw(0,0, NewBreak.GAME_WIDTH, NewBreak.GAME_HEIGHT);
    }
}
