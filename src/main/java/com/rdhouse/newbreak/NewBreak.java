package com.rdhouse.newbreak;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class NewBreak extends StateBasedGame {

    public static final String TITLE = "NewBreak";
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    public NewBreak(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new Level());
    }

    public static void main(String[] args) {
        try {
            AppGameContainer gc = new AppGameContainer(new NewBreak(TITLE));
            gc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, true);
            gc.setVSync(true);
            gc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
