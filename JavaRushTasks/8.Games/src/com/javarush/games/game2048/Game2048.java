package com.javarush.games.game2048;

import com.javarush.engine.cell.*;



public class Game2048 extends Game {
    private static final int SIDE = 4;
    private boolean isGameStopped = false;
    private int score;
    private int [][] gameField = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

    private boolean freeSpace() {
        for(int[] x: gameField){
            for(int y: x) {
                if (y == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean canUserMove(){
        if (freeSpace() == true) {
            return true;
        }
        boolean canMerge = false;
        for (int i = 0; i < 4; i++) {
            rotateClockwise();
            for(int[] row: gameField) {
                for (int j = 0; j < SIDE - 1; j++) {
                    if (row[j] == row[j + 1]) {
                        canMerge = true;
                        break;
                    }
                }
            }
        }
        if (canMerge == true) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean compressRow(int[] row) {
        int insertPosition = 0;
        boolean result = false;
        for (int x = 0; x < SIDE; x++) {
            if (row[x] > 0) {
                if (x != insertPosition) {
                    row[insertPosition] = row[x];
                    row[x] = 0;
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }
    
    private boolean my_compressRow(int[] row) {
        int position = 0;
        boolean result = false;
        for (int i = 0; i < SIDE; i++) {
            if (row[position]==0) {
                if (row[i]!=row[position]) {
                    row[position] = row[i];
                    row[i] = 0;
                    result = true;
                }
            }
            else {
                position++;
            }
        }
        return result;
    }

    private void createGame(){
        gameField = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();

    }

    private void createNewNumber(){
        int x;
        int y;
        if(getMaxTileValue() == 2048){
            win();
        } else {
            do {
                x = getRandomNumber(SIDE);
                y = getRandomNumber(SIDE);
            }
            while (gameField[x][y] != 0);
            int probably = getRandomNumber(10);
            gameField[x][y] = probably == 9 ? 4 : 2;
        }
    }

    private void drawScene(){
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                int currentValue = gameField[j][i];
                setCellColoredNumber(i,j,currentValue);
            }
        }

    }
    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED,"Вы проиграли",Color.BLACK,75);

    }
    private Color getColorByValue(int value){
        switch (value) {
            case 2:
                return Color.BLUE;
            case 4:
                return Color.ALICEBLUE;
            case 8:
                return Color.AQUA;
            case 16:
                return Color.AQUAMARINE;
            case 32:
                return Color.AZURE;
            case 64:
                return Color.BEIGE;
            case 128:
                return Color.BISQUE;
            case 256:
                return Color.DARKCYAN;
            case 512:
                return Color.BURLYWOOD;
            case 1024:
                return Color.FIREBRICK;
            case 2048:
                return Color.GOLD;
            default:
                return Color.LIGHTGRAY;
        }
    }
    private int getMaxTileValue(){
        int max = 0;
        for (int[] x:gameField) {
            for(int y: x){
                if (y > max){
                    max = y;
                }
            }
        }
        return max;
    }
    @Override
    public void initialize() {
        setScreenSize(SIDE,SIDE);
        createGame();
        drawScene();
    }

    private boolean mergeRow(int[] row){
        boolean result=false;
        for (int i = 0; i < SIDE-1; i++) {
            if (row[i]==row[i+1] && row[i]!=0) {
                row[i]*=2;
                score+=row[i];
                setScore(score);
                row[i+1]=0;
                result=true;
            }
        }
        return result;
    }

    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveLeft(){

        boolean condition3 = false;
        for (int[] row: gameField) {
            boolean condition1 = compressRow(row);
            boolean condition2 = mergeRow(row);
            if (condition2) {
                compressRow(row);
            }
            if (condition1 || condition2) {
                condition3 = true;
            }
        }
        if (condition3) {
            createNewNumber();
        }
    }

    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
            } else {
                return;
            }
        }

        if(canUserMove() == false) {
            gameOver();
            return;
        }

        if (key == Key.DOWN) {
            moveDown();
        } else if (key == Key.LEFT) {
            moveLeft();
        } else if (key == Key.RIGHT) {
            moveRight();
        } else if (key == Key.UP) {
            moveUp();
        } else {
            return;
        }
        drawScene();
    }

    private void rotateClockwise () {
        int [][] clockWisedGameField = new int[SIDE][SIDE];
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                clockWisedGameField[y][SIDE-x-1]=gameField[x][y];
            }
        }
        gameField=clockWisedGameField;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color currentCellColor = getColorByValue(value);
        String stringValue = value == 0 ? "" : Integer.toString(value);
        setCellValueEx(x, y, currentCellColor, stringValue);
        
    }
    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.GOLD,"Вы выиграли!",Color.BLANCHEDALMOND,75);
    }
}
