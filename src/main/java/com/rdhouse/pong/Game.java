package com.rdhouse.pong;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created by rutgerd on 24-7-2016.
 */
public class Game extends BasicGame {

    private static final String TITLE = "PONG!";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Rectangle player;
    private Circle ball;

    public Game(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer container) throws SlickException {
        player = new Rectangle(50, 300, 100, 20);
        ball = new Circle(300, 200, 8);

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.drawString("Welcome to PONG!", 100, 100);
        g.fill(player);
        g.fill(ball);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer ggc = new AppGameContainer(new Game(TITLE));
            ggc.setDisplayMode(WIDTH, HEIGHT, false);
            ggc.setVSync(true);
            ggc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}