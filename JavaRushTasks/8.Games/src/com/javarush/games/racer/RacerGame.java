package com.javarush.games.racer;
import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;


public class RacerGame extends Game{

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH/2; // 64/2 = 32-9 = 23
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private FinishLine finishLine;
    private boolean isGameStopped;
    private PlayerCar player;
    private ProgressBar progressBar;
    private RoadManager roadManager;
    private RoadMarking roadMarking;
    private int score;

    private void createGame() {
        isGameStopped = false;
        score = 3500;
        setTurnTimer(40);
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        drawScene();

    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (x < ROADSIDE_WIDTH || x >= WIDTH - ROADSIDE_WIDTH) {
                    setCellColor(x, y, Color.GREEN);
                } else if (x == CENTER_X) {
                    setCellColor(x,y,Color.WHITE);
                } else {
                    setCellColor(x,y,Color.DIMGREY);
                }

            }
        }
    }
    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        progressBar.draw(this);

    }
    @Override

    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        showGrid(false);
        createGame();

    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.GOLD,"YOU LOSE!", Color.BLACK,72);
        stopTurnTimer();
        player.stop();
    }

    private void moveAll(){
        roadMarking.move(player.speed);
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
        player.move();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.RIGHT) {
            player.setDirection(Direction.RIGHT);
        } else if (key == Key.LEFT) {
            player.setDirection(Direction.LEFT);
        } else if (key == Key.SPACE && isGameStopped==true) {
            createGame();
        } else if (key == Key.UP) {
            player.speed = 2;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.RIGHT && player.getDirection()==Direction.RIGHT) {
            player.setDirection(Direction.NONE);
        } else if (key == Key.LEFT && player.getDirection()==Direction.LEFT) {
            player.setDirection(Direction.NONE);
        } else if (key == Key.UP) {
            player.speed = 1;
        }

    }

    @Override
    public void onTurn(int step) {
        if (roadManager.checkCrush(player)) {
            gameOver();
        } else if (finishLine.isCrossed(player)) {
            win();
        } else {
            if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) {
                finishLine.show();

            } else {
                roadManager.generateNewRoadObjects(this);
            }
            score -= 5;
            setScore(score);
            moveAll();
        }
        drawScene();
    }



    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x<0 || x>=WIDTH || y<0 || y>=HEIGHT) {
            return;
        } else {
            super.setCellColor(x, y, color);
        }
    }

    public void setScore (int score) {
        this.score = score;
    }
    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE,"YOU WON !",Color.GOLD,72);
        stopTurnTimer();
    }
}
