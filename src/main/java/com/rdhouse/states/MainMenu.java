package com.rdhouse.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by rutgerd on 23-7-2016.
 */
public class MainMenu extends BasicGameState {

    private static final int ID = Game.MAIN_MENU;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawString("This is the main menu", 100, 100 );
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }
}
