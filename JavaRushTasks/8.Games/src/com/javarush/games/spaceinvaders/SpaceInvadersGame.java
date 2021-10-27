package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SpaceInvadersGame extends Game {
    public static final int HEIGHT = 64;
    public static final int WIDTH = 64;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;
    private int animationsCount;
    private boolean isGameStopped;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;
    private List<Bullet> playerBullets;
    private int score;

    private void check() {
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);

        enemyFleet.deleteHiddenShips();
        double bottomBorder = enemyFleet.getBottomBorder();
        if (bottomBorder >= playerShip.y) {
            playerShip.kill();
        }
        int shipsCount = enemyFleet.getShipsCount();
        if (shipsCount == 0) {
            playerShip.win();
            stopGameWithDelay();
        }
        removeDeadBullets();
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }

    }

    private void createGame() {
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        playerBullets = new ArrayList<Bullet>();
        drawScene();
        setTurnTimer(40);
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        do{
            int rndx = getRandomNumber(WIDTH);
            int rndy = getRandomNumber(HEIGHT/2);
            stars.add(new Star(rndx,rndy));
        } while (stars.size()<8);
    }

    private void drawField(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x,y,Color.BLACK,"");
            }
        }
        for (Star star: stars) {
            star.draw(this);
        }
    }

    private void drawScene() {
        drawField();
        playerShip.draw(this);
        enemyFleet.draw(this);
        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }
        for (Bullet bullet : playerBullets) {
            bullet.draw(this);
        }


    }

    @Override
    public void initialize(){
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet bullet : enemyBullets) {
            bullet.move();
        }
        for (Bullet bullet: playerBullets) {
            bullet.move();
        }
        playerShip.move();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
        } else if (key == Key.LEFT) {
            playerShip.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            playerShip.setDirection(Direction.RIGHT);
        }
        if (key == Key.SPACE) {
            Bullet bullet = playerShip.fire();
            if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                playerBullets.add(bullet);
            }
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) {
            playerShip.setDirection(Direction.UP);
        }
        if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void onTurn(int step) { //динамическая перерисовка сцены

        moveSpaceObjects();
        Bullet newBullet = enemyFleet.fire(this);
        if (newBullet != null) {
            enemyBullets.add(newBullet);
        }
        check();
        setScore(score);
        drawScene();
    }

    private void removeDeadBullets() {

        Iterator<Bullet> pBullet = playerBullets.iterator();
        while (pBullet.hasNext()) {
            Bullet bullet = pBullet.next();
            if (!bullet.isAlive || (bullet.y + bullet.height) < 0) {
                pBullet.remove();
            }
        }
        Iterator<Bullet> iBullet = enemyBullets.iterator();
        while (iBullet.hasNext()) {
            Bullet bullet = iBullet.next();
            if (!bullet.isAlive || bullet.y >= HEIGHT - 1) {
                iBullet.remove();
            }
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color color, String str) {
        if (x < 0 || x > WIDTH - 1 || y < 0 || y > HEIGHT - 1) {
            return;
        }
        super.setCellValueEx(x,y,color,str);
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) {
            showMessageDialog(Color.BLUE,"YOU WIN",Color.GREEN,72);
        } else {
            showMessageDialog(Color.BLACK,"YOU LOSE", Color.RED,72);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }

}
