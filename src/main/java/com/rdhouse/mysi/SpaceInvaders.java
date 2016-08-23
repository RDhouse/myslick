package com.rdhouse.mysi;

import org.newdawn.slick.*;

/**
 * Created by Sir Royal Air Benny on 23-8-2016.
 */
public class SpaceInvaders extends BasicGame {

    public static final String TITLE = "Space Invaders";
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private static final String SPRITE_SHEET = "./src/main/resources/spaceinvaders/space_invaders_sprites.png";

    private SpriteSheet spriteSheet;
    private Entity player;

    public SpaceInvaders(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        spriteSheet = new SpriteSheet(SPRITE_SHEET, 1, 1);
        player = new Entity(spriteSheet.getSubImage(276, 226, 28, 18));
        player.setX((GAME_WIDTH - player.getImage().getWidth()) / 2);
        player.setY(GAME_HEIGHT - 150 - 50);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.green);
        g.drawLine(0 + 20, GAME_HEIGHT - 150, GAME_WIDTH - 20, GAME_HEIGHT - 150);
        g.drawImage(player.getImage(), player.getX(), player.getY());
    }

    public static void main(String[] args) {
        try {
            AppGameContainer gc = new AppGameContainer(new SpaceInvaders(TITLE));
            gc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
            gc.setVSync(true);
            gc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
