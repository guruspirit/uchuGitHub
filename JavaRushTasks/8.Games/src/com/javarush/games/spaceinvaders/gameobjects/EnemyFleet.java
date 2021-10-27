package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyFleet {
    private static final int COLUMNS_COUNT = 10;
    private static final int ROWS_COUNT = 3;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;

    private Direction direction = Direction.RIGHT;
    private List<EnemyShip> ships;

    private void createShips() {
        ships = new ArrayList<EnemyShip>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP,y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 -1, 5));
    }

    public void deleteHiddenShips() {
        Iterator<EnemyShip> iShip = ships.iterator();
        while (iShip.hasNext()) {
            Ship ship = iShip.next();
            if (!ship.isVisible()) {
                iShip.remove();
            }
        }

    }


    public void draw(Game game) {
        for (EnemyShip ship :
                ships) {
            ship.draw(game);
        }
    }
    public EnemyFleet() {
        createShips();
    }

    public Bullet fire (Game game) {
        if (ships.size() == 0) {
            return null;
        }
        double probably = game.getRandomNumber(100/SpaceInvadersGame.COMPLEXITY);
        if (probably > 0) {
            return null;
        } else {
            int fighter = game.getRandomNumber(ships.size());
            return ships.get(fighter).fire();
        }
    }

    public double getBottomBorder() {
        double maxY = 0;
        for(EnemyShip enemyShip: ships) {
            double curY = enemyShip.y + enemyShip.height;
            if (maxY < curY) {
                maxY = curY;
            }
        }
        return maxY;
    }

    private double getLeftBorder() {
        double min = 0;
        if (ships.size() > 1) {
            min = ships.get(0).x;
        } else {return 0;}
        for (Ship ship :
                ships) {
            if (ship.x < min) {
                min = ship.x;
            }
        }
        return min;
    }

    private double getRightBorder() {
        double max = 0;
        if (ships.size() > 1) {
            max = ships.get(0).x + ships.get(0).width;
        } else {return 0;}
        for (Ship ship :
                ships) {
            if (ship.x + ship.width > max) {
                max = ship.x + ship.width;
            }
        }
        return max;
    }

    public int getShipsCount() {
        return ships.size();
    }

    private double getSpeed() {
        double spd = 3.0 / ships.size();
        if (spd < 2.0) {
            return spd;
        } else {
            return 2.0;
        }
    }

    public void move() {
        boolean isChanged = false;
        if (ships.size() == 0) {
            return;
        }
        double speed = getSpeed();
        if (direction == Direction.LEFT && getLeftBorder() < 0) {
            direction = Direction.RIGHT;
            isChanged = true;
        } else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
            isChanged = true;
        }
        if (isChanged) {
            for (EnemyShip ship :
                    ships) {
                ship.move(Direction.DOWN, speed);
            }
        } else{
            for (EnemyShip ship :
                    ships) {
                ship.move(direction, speed);
            }
        }
    }

    public int verifyHit(List<Bullet> bullets) {
        if (bullets.size() == 0) {
            return 0;
        }
        int localScore = 0;
        for (Bullet bullet: bullets) {
            for (EnemyShip ship: ships) {
                if (ship.isCollision(bullet) && ship.isAlive && bullet.isAlive) {
                    ship.kill();
                    localScore += ship.score;
                    bullet.kill();
                }
            }
        }
        return localScore;
    }


}
