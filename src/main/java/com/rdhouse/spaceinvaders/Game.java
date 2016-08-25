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

    // Resource locations
    public static final String ALL_KEY = "ALL_KEY";
    private static final String SPRITE_SHEET_ALL = "./src/main/resources/spaceinvaders/space_invaders_sprites.png";
    public static final String COLORED_KEY = "COLORED_KEY";
    private static final String SPRITE_SHEET_COLORED = "./src/main/resources/spaceinvaders/spaceinvaders_colored.png";

    public Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new SplashScreen());
        this.addState(new MainMenu());
        this.addState(new Level());
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
