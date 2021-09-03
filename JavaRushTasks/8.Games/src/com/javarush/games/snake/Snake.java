package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake{
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public boolean checkCollision(GameObject gameObject){
        for (int i = 0; i < snakeParts.size(); i++) {
            if (snakeParts.get(i).x == gameObject.x &&
                    snakeParts.get(i).y == gameObject.y)
                return true;
        }
        return false;
    }
    public GameObject createNewHead() {
        if(direction==Direction.LEFT)
            return new GameObject(snakeParts.get(0).x-1,snakeParts.get(0).y);
        else if(direction==Direction.RIGHT)
            return new GameObject(snakeParts.get(0).x+1,snakeParts.get(0).y);
        else if(direction==Direction.UP)
            return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y-1);
        else
            return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y+1);
    }

    public void draw(Game game){
        Color snakeColor;
        if(isAlive)
            snakeColor=Color.GREEN;
        else
            snakeColor=Color.RED;
        for (int i = 0; i < snakeParts.size(); i++) {
            if(i==0)
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y,Color.NONE,HEAD_SIGN,snakeColor,75);
            else
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y,Color.NONE,BODY_SIGN,snakeColor,75);
        }
    }

    public int getLength(){
        return snakeParts.size();

    }

    public void move(Apple apple){
        GameObject newHead = createNewHead();
        if(newHead.x<0 || newHead.x>SnakeGame.WIDTH -1 ||
                newHead.y<0 || newHead.y>SnakeGame.HEIGHT-1)
                isAlive=false;
        else {
            if (checkCollision(newHead))
                isAlive = false;
            else if (newHead.x == apple.x && newHead.y == apple.y) {
                snakeParts.add(0, newHead);
                apple.isAlive = false;
            }
            else {
                snakeParts.add(0, newHead);
                removeTail();
            }
        }
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }

    public void setDirection(Direction direction){
        int x1 = snakeParts.get(0).x;
        int x2 = snakeParts.get(1).x;
        int y1 = snakeParts.get(0).y;
        int y2 = snakeParts.get(1).y;
        if (    (this.direction==Direction.LEFT  && x1==x2) ||
                (this.direction==Direction.RIGHT && x1==x2) ||
                (this.direction==Direction.UP    && y1==y2) ||
                (this.direction==Direction.DOWN  && y1==y2) )
            return;
        if (    (direction==Direction.LEFT  && this.direction!=Direction.RIGHT)||
                (direction==Direction.RIGHT && this.direction!=Direction.LEFT) ||
                (direction==Direction.UP    && this.direction!=Direction.DOWN) ||
                (direction==Direction.DOWN  && this.direction!=Direction.UP) )
            this.direction = direction;


    }

    public Snake(int x, int y){
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
    }
}
