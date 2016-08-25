package com.rdhouse.mysi;

import org.newdawn.slick.*;

/**
 * Created by Sir Royal Air Benny on 23-8-2016.
 */
public class SpaceInvaders extends BasicGame {

    public static final String TITLE = "Space Invaders";
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private static final String SPRITE_SHEET = "./src/main/resources/spaceinvaders/spaceinvaders_colored.png";
    private static final String BACKGROUND = "./src/main/resources/spaceinvaders/spaceinvaders_bg1.png";

    private SpriteSheet spriteSheet;
    private Image background;
    private Player player;
    private Enemy enemy_one;
    private Input input;

    public SpaceInvaders(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        spriteSheet = new SpriteSheet(SPRITE_SHEET, 1, 1, Color.black);
        background = new Image(BACKGROUND);
        input = container.getInput();
        initPlayer();
        initEnemy();
    }

    private void initEnemy() {
        Image[] images = new Image[3];
        images[0] = spriteSheet.getSubImage(2, 3, 12, 11);
        images[1] = spriteSheet.getSubImage(18, 3, 12, 11);
        images[2] = spriteSheet.getSubImage(34, 3, 12, 11);

        Image image = images[0].getScaledCopy(1);

        enemy_one = new Enemy(image);

        enemy_one.setX(408);
        enemy_one.setY(100);

        enemy_one.setAnimation(images, 350);
        enemy_one.getAnimation().setPingPong(true);
    }

    private void initPlayer() {
        Image[] images = new Image[3];
        images[0] = spriteSheet.getSubImage(2, 50, 12, 13).getFlippedCopy(false, true);
        images[1] = spriteSheet.getSubImage(18, 50, 12, 13).getFlippedCopy(false, true);
        images[2] = spriteSheet.getSubImage(34, 50, 12, 13).getFlippedCopy(false, true);

        player = new Player(images[0]);

        player.setAnimation(images, 150);

        player.setX((GAME_WIDTH - player.getImage().getWidth()) / 2);
        player.setY(GAME_HEIGHT - 100 - 50);

        player.setSpeed(2);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        updatePlayer();
        updateEnemy();

    }

    private void updatePlayer() {
        // Controls
        if (input.isKeyDown(Input.KEY_A)) {
            if (!(player.getX() <= 20)) {
               player.setX(player.getX() - player.getSpeed());
            }
        }
        if (input.isKeyDown(Input.KEY_D)) {
            if (!(player.getX() >= GAME_WIDTH - 20 - player.getImage().getWidth())) {
                player.setX(player.getX() + player.getSpeed());
            }
        }
    }

    private void updateEnemy() {
        int speed = 2;
        if (enemy_one.isLeft()) {
            if (enemy_one.getX() > 20) {
                enemy_one.setX(enemy_one.getX() - speed);
            } else {
                enemy_one.setLeft(false);
                enemy_one.setY(enemy_one.getY() + enemy_one.getImage().getHeight());
            }
        } else {
            if (enemy_one.getX() < GAME_WIDTH - 20 - enemy_one.getImage().getWidth()) {
                enemy_one.setX(enemy_one.getX() + speed);
            } else {
                enemy_one.setLeft(true);
                enemy_one.setY(enemy_one.getY() + enemy_one.getImage().getHeight());
            }
        }


    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0, GAME_WIDTH, GAME_HEIGHT, 0, 216, 512, 835);
        drawBottomLine(g);

        //g.drawImage(player.getImage(), player.getX(), player.getY());
        //g.drawImage(enemy_one.getImage(), 200, 200);
        player.render();
        g.drawAnimation(enemy_one.getAnimation(), enemy_one.getX(), enemy_one.getY());
    }

    private void drawBottomLine(Graphics g) {
        g.setColor(Color.green);
        g.drawLine(20, GAME_HEIGHT - 100, GAME_WIDTH - 20, GAME_HEIGHT - 100);
        g.setColor(Color.white);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer gc = new AppGameContainer(new SpaceInvaders(TITLE));
            gc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
            gc.setVSync(true);
            gc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
