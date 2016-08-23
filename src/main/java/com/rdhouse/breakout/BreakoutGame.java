package com.rdhouse.breakout;

import org.newdawn.slick.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rutger Dijkhuizen on 27-7-2016.
 */
public class BreakoutGame extends BasicGame {

    private static final String TITLE = "Breakout";
    private static final String SPRITE_SHEET_URL = "./src/main/resources/breakout/breakout_sprites.png";
    private static final String BACKGROUND_SHEET_URL = "./src/main/resources/breakout/breakout_bg.png";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final int NUM_ROWS = 3;
    private static final int NUM_COLS = 15;
    public static final int BRICK_WIDTH = 32;

    private Image background;
    private SpriteSheet sheet;
    private Image player;
    private Image ball;
    private List<Brick> bricks;

    private class Brick {

        private Image image;
        private int x, y;

        public Brick(Image image) {
            this.image = image;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Image getImage() {
            return image;
        }
    }


    public BreakoutGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        background = new Image(BACKGROUND_SHEET_URL);
        sheet = new SpriteSheet(SPRITE_SHEET_URL, BRICK_WIDTH, BRICK_WIDTH, 8);
        player = sheet.getSubImage(0, 200, 96, 24);
        ball = sheet.getSubImage(160, 200, 16, 16);
        bricks = initBricks();
    }

    private List<Brick> initBricks() {
        List<Brick> bricks = new LinkedList<>();
        int startY = 100;
        int startX = (WIDTH - (NUM_COLS * BRICK_WIDTH)) / 2;
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                Brick brick = new Brick(sheet.getSprite(i, 0));
                brick.setX(startX + j * BRICK_WIDTH);
                brick.setY(startY + i * BRICK_WIDTH);
                bricks.add(brick);
            }

        }
        return bricks;
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        g.drawImage(player, 200, 200);
        g.drawImage(ball, 200, 300);

        for (Brick brick : bricks) {
            g.drawImage(brick.getImage(), brick.getX(), brick.getY());
        }
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
