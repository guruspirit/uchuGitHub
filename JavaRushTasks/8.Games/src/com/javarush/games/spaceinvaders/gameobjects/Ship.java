package com.javarush.games.spaceinvaders.gameobjects;


import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject{
    public boolean isAlive = true;
    private int frameIndex;
    private List<int[][]> frames;
    private boolean loopAnimation = false;


    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }
    public Bullet fire() {
        return null;
    }

    public boolean isVisible() {
        if (!isAlive && frameIndex >= frames.size()) {
            return false;
        }
        return true;
    }

    public void kill() {
        isAlive = false;
    }

    public void nextFrame() {
        frameIndex++;
        if (frameIndex >= frames.size() - 1 && loopAnimation == false) {
            return;
        }
        if (frameIndex >= frames.size() - 1 && loopAnimation == true) {
            frameIndex = 0;
        }


        matrix = frames.get(frameIndex);
    }
    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
        setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
    }

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame) {
        frames = new ArrayList<int[][]>();
        frames.add(viewFrame);
        frameIndex = 0;
        setMatrix(viewFrame);
    }
}
