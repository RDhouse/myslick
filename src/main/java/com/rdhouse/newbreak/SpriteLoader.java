package com.rdhouse.newbreak;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * Created by RDHouse on 6-9-2016.
 */
public class SpriteLoader {

    private static SpriteSheet sheet;
    private static final String SPRITE_SHEET_URL = "src/main/resources/breakout/breakout_sprites.png";

    static {
        try {
            sheet = new SpriteSheet(SPRITE_SHEET_URL, 1, 1);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public static Image getSprite(int xPos, int yPos, int width, int height)  {
        return sheet.getSubImage(xPos, yPos, width, height);
    }
}
