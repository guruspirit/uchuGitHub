package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countClosedTiles = SIDE * SIDE;
    private int countFlags;
    private int countMinesOnField;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void countMineNeighbors() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (!gameField[y][x].isMine) {
                    int countMineNeighbors = 0;
                    List <GameObject> neighbors = getNeighbors(gameField[y][x]);
                    for (GameObject object: neighbors) {
                        if (object.isMine) {
                            countMineNeighbors++;
                        }
                    }
                    gameField[y][x].countMineNeighbors = countMineNeighbors;
                }
            }
        }
    }
    private void createGame() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED,"Game over", Color.BLACK,72);
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void markTile(int x, int y) {
        if (isGameStopped) {
            return;
        }
        GameObject currentTile = gameField[y][x];
        if (!currentTile.isOpen && countFlags > 0 && !currentTile.isFlag) {
            currentTile.isFlag = true;
            countFlags--;
            setCellValue(x,y,FLAG);
            setCellColor(x,y,Color.YELLOW);
        } else if (currentTile.isFlag) {
            currentTile.isFlag = false;
            countFlags++;
            setCellValue(x,y,"");
            setCellColor(x,y,Color.ORANGE);
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        } else {
            openTile(x, y);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) { markTile(x, y); }

    private void openTile(int x, int y) {
        GameObject currentTile =  gameField[y][x];
        if (currentTile.isOpen || currentTile.isFlag || isGameStopped) {
            return;
        }
        currentTile.isOpen = true;
        countClosedTiles--;
        if (currentTile.isMine) {
            setCellValueEx(x,y,Color.RED,MINE);
            gameOver();
        } else {
            score+=5;
            setScore(score);
            if (countClosedTiles == countMinesOnField) {
                win();
            }
            if (currentTile.countMineNeighbors == 0) {
                for (GameObject neighbor: getNeighbors(currentTile)) {
                    if (!neighbor.isOpen) {
                        openTile(neighbor.x,neighbor.y);
                    }
                }
                setCellValue(x,y,"");
            } else {
                if (currentTile.countMineNeighbors > 0) {
                    setCellNumber(x, y, currentTile.countMineNeighbors);
                }
            }

        }
        setCellColor(x,y,Color.GREEN);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }
    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GOLD,"YOU WON",Color.BLACK,72);
    }
}