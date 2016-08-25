package com.rdhouse.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by rutgerd on 23-7-2016.
 */
public class SplashScreen extends BasicGameState {

    private static final int ID = Game.SPLASH_SCREEN;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawString("Welcome to myGame", 100, 100);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyDown(Input.KEY_SPACE)) {
            game.enterState(Game.MAIN_MENU);
        }
    }
}
