package com.rdhouse.spaceinvaders;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by rutgerd on 23-8-2016.
 */
public class SplashScreen extends BasicGameState {

    private final int ID;

    private Image splashImage;

    public SplashScreen(int ID) {
        this.ID = ID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        splashImage = Sheet.getSheet().getSubImage(172, 0, 231, 168);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(splashImage, (Game.GAME_WIDTH - splashImage.getWidth()) / 2
                , (Game.GAME_HEIGHT - splashImage.getHeight()) / 2);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_SPACE)) {
            System.out.println("Now in splash screen");
            container.getInput().clearKeyPressedRecord();
            game.enterState(Game.LEVEL);
        }
    }
}
