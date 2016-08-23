package com.rdhouse.title;

import org.newdawn.slick.*;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rutgerd on 23-7-2016.
 */
public class Game extends BasicGame {

    private String backgroundRef = "src\\main\\resources\\background.png";
    private SpriteSheet background;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        background = new SpriteSheet(new Image(backgroundRef), 3121, 480);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.drawImage(background.getSubImage(0, 0), 0, 0);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer ggc = new AppGameContainer(new Game("my game"));
            ggc.setDisplayMode(800, 600, false);
            ggc.setVSync(true);
            ggc.start();
        } catch (SlickException e) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, e.getMessage());
        }
    }
}
