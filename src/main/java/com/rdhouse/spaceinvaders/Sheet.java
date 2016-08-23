package com.rdhouse.spaceinvaders;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * Created by rutgerd on 23-8-2016.
 */
public class Sheet {

    private static final String SPRITE_STRING = "./src/main/resources/spaceinvaders/space_invaders_sprites.png";

    private static SpriteSheet sheet;

    static {
        try {
            sheet = new SpriteSheet(SPRITE_STRING, 16, 16);
            sheet.setImageColor(0, 0, 0);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public static SpriteSheet getSheet() {
        return sheet;
    }
}
