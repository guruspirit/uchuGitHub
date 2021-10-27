package com.javarush.games.minesweeper;
import com.javarush.engine.cell.*;
public class GameObject{
    public int countMineNeighbors = 0;
    public boolean isFlag;
    public boolean isMine;
    public boolean isOpen;

    public int x;
    public int y;
    public GameObject(int newX, int newY, boolean newMine) {
        x = newX;
        y = newY;
        isMine = newMine;

    }
}
