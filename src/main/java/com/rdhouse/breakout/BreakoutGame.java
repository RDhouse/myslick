package com.rdhouse.breakout;

import org.newdawn.slick.*;

import java.util.List;

/**
 * Created by rutgerd on 27-7-2016.
 */
public class BreakoutGame extends BasicGame {

    private static final String TITLE = "Breakout";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private Image background;
    private SpriteSheet sheet;
    private static final String SPRITE_SHEET_URL = "./src/main/resources/breakout/breakout_sprites.png";
    private static final String BACKGROUND_SHEET_URL = "./src/main/resources/breakout/breakout_bg.png";
    private Image player;
    private Image ball;
    private List<Image> bricks;


    public BreakoutGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        background = new Image(BACKGROUND_SHEET_URL);
        sheet = new SpriteSheet(SPRITE_SHEET_URL, 32, 32, 8);
        player = sheet.getSubImage(0, 200, 96, 24);
        ball = sheet.getSubImage(160, 200, 16, 16);
        bricks = initBricks();
    }

    private List<Image> initBricks() {
        return null;
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        g.drawImage(player, 200, 200);
        g.drawImage(ball, 200, 300);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer ggc = new AppGameContainer(new BreakoutGame(TITLE));
            ggc.setDisplayMode(WIDTH, HEIGHT, false);
            ggc.setVSync(true);
            ggc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
