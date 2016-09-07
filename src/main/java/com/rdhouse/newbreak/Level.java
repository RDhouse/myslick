package com.rdhouse.newbreak;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Iterator;
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

    private int rows = 5, cols = 9;
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
        ball.location.set(player.location.x + 50, player.location.y - 50);
        ball.acceleration.set(1.0f, -10.0f);

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
        bricks.forEach(Brick::render);

        //drawBounds(g);
    }

    private void drawBounds(Graphics g) {
        g.draw(player.getBounds());
        g.draw(ball.getBounds());
        for (Brick brick : bricks) {
            g.draw(brick.getBounds());
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        player.update();
        ball.update();
        bricks.forEach(Brick::update);
        collisions();

        if (gameOver()) {
            game.getState(Level.ID).init(container, game);
            game.enterState(Level.ID);
        }
    }

    private void collisions() {
        // Ball with player
        if (ball.getBounds().intersects(player.getBounds())) {
            // TODO: angles NOT YET PROPER!
            float centerPlayer = player.getBounds().getCenterX();
            float centerBall = ball.getBounds().getCenterX();
            float diff = Math.abs(centerPlayer - centerBall);
            System.out.println(diff);
            System.out.println(ball.velocity.getTheta());
            if (ball.velocity.getTheta() < 90) {
                ball.velocity.setTheta(90 + diff);
            } else {
                ball.velocity.setTheta(90 - diff);
            }
            ball.velocity.y *= -1;
        }
        // Ball with bricks
        for (Iterator<Brick> iterator = bricks.iterator(); iterator.hasNext();) {
            Brick brick = iterator.next();
            if (brick.getBounds().intersects(ball.getBounds())) {
                // decide direction
                float ballX = ball.getBounds().getCenterX();
                float ballY = ball.getBounds().getCenterY();
                float brickMinX = brick.getBounds().getMinX();
                float brickMinY = brick.getBounds().getMinY();
                float brickMaxX = brick.getBounds().getMaxX();
                float brickMaxY = brick.getBounds().getMaxY();
                if (ballX < brickMinX || ballX > brickMaxX) { // left or right side of brick
                    ball.velocity.x *= -1;
                }
                if (ballY < brickMinY || ballY > brickMaxY) { // top or bottom side of brick
                    ball.velocity.y *= -1;
                }
                // remove brick from list
                iterator.remove();
            }
        }
    }

    private boolean gameOver() {
        return bricks.isEmpty();
    }
}
