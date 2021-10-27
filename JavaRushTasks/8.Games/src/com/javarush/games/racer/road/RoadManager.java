package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;
import com.javarush.games.racer.GameObject;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH; //14
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER; //64-14=50
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList<>();
    private static final int PLAYER_CAR_DISTANCE = 12;
    private int passedCarsCount = 0;

    private void addRoadObject(RoadObjectType type, Game game){
        int x = game.getRandomNumber(FIRST_LANE_POSITION,FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject roadObject = createRoadObject(type,x,y);
        if (roadObject != null && isRoadSpaceFree(roadObject)) {
            items.add(roadObject);
        }

    }

    public boolean checkCrush(PlayerCar playerCar) {
        for (RoadObject item: items) {
            if (item.isCollision(playerCar)) {
                return true;
            }
        }
        return false;
    }

    private RoadObject createRoadObject(RoadObjectType type, int x, int y){
        if (type == RoadObjectType.THORN) {
            return new Thorn(x, y);
        }
        else if (type == RoadObjectType.DRUNK_CAR) {
            return new MovingCar(x,y);
        }
        else {
            return new Car(type,x,y);
        }

    }

    private void deletePassedItems () {
        Iterator<RoadObject> roadObjectIterator = items.iterator();
        while (roadObjectIterator.hasNext()) {
            RoadObject currentRoadObject = roadObjectIterator.next();
            if (currentRoadObject.y >= RacerGame.HEIGHT) {
                if (currentRoadObject.type != RoadObjectType.THORN) {
                    passedCarsCount++;
                }
                roadObjectIterator.remove();
            }
        }

    }

    public void draw (Game game) {
        for(RoadObject roadObject: items) {
            roadObject.draw(game);
        }
    }

    private void generateMovingCar(Game game) {
        if (game.getRandomNumber(100) < 10 && !isMovingCarExists()) {
            addRoadObject(RoadObjectType.DRUNK_CAR,game);
        }
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
        generateMovingCar(game);

    }

    private void generateRegularCar(Game game) {
        if (game.getRandomNumber(100) < 30) {
            int carTypeNumber = game.getRandomNumber(4);
            addRoadObject(RoadObjectType.values()[carTypeNumber],game);

        }
    }
    private void generateThorn(Game game) {
        if (game.getRandomNumber(100) < 10 && !isThornExists()) {
            addRoadObject(RoadObjectType.THORN,game);
        }
    }

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    private boolean isMovingCarExists() {
        for (RoadObject roadObject: items) {
            if (roadObject.type == RoadObjectType.DRUNK_CAR) {
                return true;
            }
        }
        return false;
    }
    private boolean isRoadSpaceFree(RoadObject object) {
        for(RoadObject roadObject: items) {
            if (roadObject.isCollisionWithDistance(object,PLAYER_CAR_DISTANCE)) {
                return false;
            }
        }
        return true;
    }

    private boolean isThornExists() {
        for(RoadObject roadObject: items) {
            if (roadObject.type == RoadObjectType.THORN) {
                return true;
            }
        }
        return false;

    }

    public void move (int boost) {

        for(RoadObject roadObject: items) {
            roadObject.move(roadObject.speed + boost,items);
        }
        deletePassedItems();
    }

}
