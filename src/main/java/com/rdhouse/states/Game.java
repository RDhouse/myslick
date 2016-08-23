package com.rdhouse.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by rutgerd on 23-7-2016.
 */
public class Game extends StateBasedGame {

    // Game state identifiers
    public static final int SPLASHSCREEN = 0;
    public static final int MAINMENU = 1;
    public static final int LEVEL = 2;

    // App properties
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int TARGET_FPS = 60;
    public static final String TITLE = "MyGame";
    public static final String VERSION = "1.0.0";
    public static final String AUTHOR = "RdHouse";

    public Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new SplashScreen(SPLASHSCREEN));
        this.addState(new MainMenu(MAINMENU));
        this.addState(new Level(LEVEL));
    }

    public static void main(String[] args) {
        try {
            AppGameContainer ggc = new AppGameContainer(new Game(TITLE + " - " + VERSION + " - by: " + AUTHOR ));
            ggc.setDisplayMode(WIDTH, HEIGHT, false);
            ggc.setTargetFrameRate(TARGET_FPS);
            ggc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
