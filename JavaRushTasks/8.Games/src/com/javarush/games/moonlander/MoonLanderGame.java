package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;


public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private GameObject platform;
    private boolean isGameStopped;
    private int score;


    private void check() {
        if (rocket.isCollision(landscape) && !(rocket.isCollision(platform) && rocket.isStopped())) {
            gameOver();
        }
        if (rocket.isCollision(platform) && rocket.isStopped()) {
            win();
        }
    }
    private void createGame() {
        isLeftPressed = false;
        isUpPressed = false;
        isRightPressed = false;
        isGameStopped = false;
        createGameObjects();
        setTurnTimer(50);
        score = 1000;
        drawScene();
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH/2,0);
        landscape = new GameObject(0,25, ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23,MoonLanderGame.HEIGHT-1, ShapeMatrix.PLATFORM);
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.BLACK);
            }
        }
        landscape.draw(this);
        rocket.draw(this);
    }

    private void gameOver() {
        rocket.crash();
        isGameStopped = true;
        score = 0;
        showMessageDialog(Color.RED, "Game over!", Color.BLACK, 72);
        stopTurnTimer();
    }
    @Override
    public void initialize(){
        setScreenSize(WIDTH, HEIGHT);
        showGrid(false);
        createGame();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.UP) {
            isUpPressed = true;
        } else if (key == Key.LEFT) {
            isLeftPressed = true;
            isRightPressed = false;
        } else if (key == Key.RIGHT) {
            isRightPressed = true;
            isLeftPressed = false;
        } else if (key == Key.SPACE && isGameStopped == true) {
            createGame();
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.UP) {
            isUpPressed = false;
        } else if (key == Key.LEFT) {
            isLeftPressed = false;
        } else if (key == Key.RIGHT) {
            isRightPressed = false;
        }
    }

    @Override
    public void onTurn(int x){
        rocket.move(isUpPressed,isLeftPressed,isRightPressed);
        check();
        if (score>0)
            score--;
        setScore(score);
        drawScene();

    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x < 0 || x > WIDTH-1 || y > HEIGHT-1 || y < 0 ) {
            return;
        } else {
            super.setCellColor(x,y,color);
        }
    }

    private void win() {
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.GOLD,"YOU WON",Color.WHITE,72);
        stopTurnTimer();
    }

}
