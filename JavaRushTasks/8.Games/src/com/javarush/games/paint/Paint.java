package com.javarush.games.paint;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;
import com.javarush.engine.cell.Color;

public class Paint extends Game{
    public static final int width = 10;
    public static final int height = 10;
    private Color leftColor = Color.BLACK;
    private Color rightColor = Color.WHITE;
    @Override
    public void initialize() {
        setScreenSize(width,height);


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                setCellColor(i,j,Color.WHITE);
            }
        }
        setCellColor(0,0, Color.RED);
        setCellColor(1,0, Color.GREEN);
        setCellColor(2,0, Color.BLUE);
        setCellColor(3,0, Color.WHITE);
        setCellColor(4,0, Color.BLACK);

        setCellValueEx(width-2,0,leftColor,"L",Color.GOLD,72);
        setCellValueEx(width-1,0,rightColor,"R",Color.GOLD,72);
    }
    @Override
    public void onMouseLeftClick(int x, int y) {
        if (y == 0) {
            leftColor = getCellColor(x,y);
            setCellColor(width-2, 0, leftColor);
        } else {
            setCellColor(x, y, leftColor);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        if (y == 0) {
            rightColor = getCellColor(x,y);
            setCellColor(width-1, 0, rightColor);
        } else {
            setCellColor(x, y, rightColor);
        }
    }

}
