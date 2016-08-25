package com.rdhouse.newbreak;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class Level extends BasicGameState{

    public static final int ID = 1;

    private SpriteSheet spriteSheet;
    private Background background;
    private Player player;
    private Ball ball;
    private Brick brick;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        spriteSheet = new SpriteSheet("src/main/resources/breakout/breakout_sprites.png", 39, 39, 1);
        background = new Background(new Image("src/main/resources/breakout/breakout_bg.png"));

        // Player
        player = new Player(spriteSheet.getSubImage(0, 200, 101, 30), container.getInput());
        player.getPosition().set((NewBreak.GAME_WIDTH - player.getWidth()) / 2, NewBreak.GAME_HEIGHT - player.getHeight() * 2);
        player.getSpeed().set(2, 0);

        // Ball
        ball = new Ball(spriteSheet.getSubImage(160, 200, 16, 16));
        ball.getPosition().set(250f, 300f);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        background.render();
        player.render();
        ball.render();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        player.update();
    }
}
