package com.rdhouse.newbreak;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sir Royal Air Benny on 25-8-2016.
 */
public class Level extends BasicGameState{

    public static final int ID = 1;

    private Background background;
    private Player player;
    private Ball ball;

    private int rows = 5, cols = 8;
    private List<Brick> bricks = new LinkedList<>();


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        background = new Background(new Image("src/main/resources/breakout/breakout_bg.png"));

        // Player
        player = new Player(SpriteLoader.getSprite(0, 200, 101, 30), container.getInput());
        player.location.x  = (NewBreak.GAME_WIDTH - player.getWidth()) / 2;
        player.location.y = NewBreak.GAME_HEIGHT - player.getHeight() * 2;

        // Ball
        ball = new Ball(SpriteLoader.getSprite(160, 200, 16, 16));
        ball.location.set(300, 300);
        ball.acceleration.set(-6.5f, 2.0f);

        // Bricks
        float y = (NewBreak.GAME_HEIGHT - rows * 40) / 2 - 100;
        for (int i = 0; i < rows; i++) {
            float x = (NewBreak.GAME_WIDTH - cols * 40) / 2;
            for (int j = 0; j < cols; j++) {
                Brick brick = new Brick(BrickType.ORANGE.getImage());
                brick.location.set(x, y);
                bricks.add(brick);
                x += 40;
            }
            y += 40;
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        background.render();
        player.render();
        ball.render();
        for (Brick brick : bricks) {
            brick.render();
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        player.update();
        ball.update();
        for (Brick brick : bricks) {
            brick.update();
        }
    }
}
