package com.javarush.games.racer;
import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class PlayerCar extends GameObject {
    public int speed = 1;
    private Direction direction;
    private static int playerCarHeight = ShapeMatrix.PLAYER.length;

    public Direction getDirection() {
        return direction;
    }

    public void move() {

        if (x < RoadManager.LEFT_BORDER) {
            x = RoadManager.LEFT_BORDER;
        }
        if (x + width > RoadManager.RIGHT_BORDER) {
            x = RoadManager.RIGHT_BORDER - width;
        }

        if (direction == Direction.LEFT) {
            x -= 1;
        } else if (direction == Direction.RIGHT) {
            x += 1;
        }
    }

    public PlayerCar() {

        super(RacerGame.WIDTH / 2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void stop () {
        matrix = ShapeMatrix.PLAYER_DEAD;
    }
}
