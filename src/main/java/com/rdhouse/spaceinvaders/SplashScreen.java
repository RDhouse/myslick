package com.rdhouse.spaceinvaders;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by rutgerd on 23-8-2016.
 */
public class SplashScreen extends BasicGameState {

    public static final int ID = 0;

    private Image splashImage;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
//        g.drawImage(splashImage, (Game.GAME_WIDTH - splashImage.getWidth()) / 2
//                , (Game.GAME_HEIGHT - splashImage.getHeight()) / 2);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyDown(Input.KEY_SPACE)) {
            game.enterState(MainMenu.ID);
        }
    }
}
