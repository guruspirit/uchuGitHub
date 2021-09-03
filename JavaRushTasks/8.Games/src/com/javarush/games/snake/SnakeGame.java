package com.javarush.games.snake;
import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;
    private int score;
    private Snake snake;
    private boolean isGameStopped;
    private int turnDelay;
    private Apple apple;

    private void createGame() {
        score = 0;
        setScore(score);
        isGameStopped=false;
        snake=new Snake(WIDTH/2,HEIGHT/2);
        turnDelay=300;
        setTurnTimer(turnDelay);
        createNewApple();
        drawScene();

    }
    private void createNewApple(){
        int x,y;
        Apple apple;
        do {
            x = getRandomNumber(WIDTH);
            y = getRandomNumber(HEIGHT);
            apple = new Apple(x, y);
        } while (snake.checkCollision(apple));
        this.apple=apple;

    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i,j,Color.WHEAT,"");
            }
        }

        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GRAY,"Game Over, BADDY", Color.BLANCHEDALMOND,75);
    }
    @Override
    public void onKeyPress(Key key) {
        if(key==Key.LEFT){
            snake.setDirection(Direction.LEFT);
        }
        if(key==Key.RIGHT){
            snake.setDirection(Direction.RIGHT);
        }
        if(key==Key.UP){
            snake.setDirection(Direction.UP);
        }
        if(key==Key.DOWN){
            snake.setDirection(Direction.DOWN);
        }
        if(key==Key.SPACE && isGameStopped == true){
            createGame();
        }
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if(apple.isAlive==false) {
            createNewApple();
            score+=5;
            setScore(score);
            turnDelay-=10;
            setTurnTimer(turnDelay);
        }
        if (snake.isAlive == false)
            gameOver();
        if (snake.getLength()>GOAL)
            win();
        drawScene();
    }

    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.WHITESMOKE,"YOU ARE THE BEST!",Color.BLUEVIOLET,75);

    }
}
