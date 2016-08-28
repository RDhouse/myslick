package com.rdhouse.natureofcode;

import org.newdawn.slick.*;

/**
 * Created by Sir Royal Air Benny on 26-8-2016.
 */
public class App extends BasicGame {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    private Image background;
    private SpriteSheet sheet;
    private Ball ball;
    private Input input;

    public App(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        input = container.getInput();

        background = new Image("src/main/resources/breakout/breakout_bg.png");
        sheet = new SpriteSheet("src/main/resources/breakout/breakout_sprites.png", 1, 1);

        ball = new Ball(sheet.getSubImage(160, 200, 16, 16));

        ball.location.set(WIDTH/2, HEIGHT/2);
        ball.velocity.set(0f, 0f);
        //ball.acceleration.set(0f, 0f);

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        ball.update(container.getInput());
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        background.draw(0, 0, WIDTH, HEIGHT);
        ball.render();
    }

    public static void main(String[] args) {
        try {
            AppGameContainer gc = new AppGameContainer(new App(""));
            gc.setDisplayMode(WIDTH, HEIGHT, false);
            gc.setVSync(true);
            gc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
