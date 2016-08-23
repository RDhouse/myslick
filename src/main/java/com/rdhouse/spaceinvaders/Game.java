package com.rdhouse.spaceinvaders;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by rutgerd on 23-8-2016.
 */
public class Game extends StateBasedGame {

    // Title, Size etc
    public static final String TITLE = "Space Invaders";
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    // ID's of all game states.
    public static final int SPLASH_SCREEN = 0;
    public static final int MAIN_MENU = 1;
    public static final int LEVEL = 2;

    public Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new SplashScreen(SPLASH_SCREEN));
        addState(new SplashScreen(MAIN_MENU));
        addState(new SplashScreen(LEVEL));
    }

    public static void main(String[] args) {
        try {
            AppGameContainer gc = new AppGameContainer(new Game(TITLE));
            gc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
            gc.setVSync(true);
            gc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
