package com.company;

public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;
    private int[][] goalIndex;
    private Levels levels;
    private boolean isPlay;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        levels = new Levels();
        init();
    }

    private void init(){
        desktop = new int[][]{
                {2, 2, 2, 2, 2},
                {2, 0, 0, 0, 2},
                {2, 0, 0, 0, 2},
                {2, 0, 0, 0, 2, 2, 2, 2, 2, 2},
                {2, 4, 2, 3, 1, 0, 3, 0, 4, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2}
        };

        indexX = 4;
        indexY = 4;
        desktop[indexX][indexY] = 1;
    }

    public void move(String direction) throws Exception {
        if (direction.equals("Up")) moveUp();
        else if (direction.equals("Right")) moveRight();
        else if (direction.equals("Down")) moveDown();
        else if (direction.equals("Left")) moveLeft();
        else return;
        checkGoal();
        won();
        viewer.update();
    }

    private void nextLevel(){
        desktop = new int[][]{
                {2, 2, 2, 2},
                {2, 1, 0, 2},
                {2, 0, 2, 2},
                {2, 0, 2},
                {2, 0, 2, 2, 2, 2, 2, 2, 2},
                {2, 3, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 2, 2, 2, 2, 0, 2},
                {2, 0, 2, 2, 2, 2, 2, 0, 2},
                {2, 4, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},

        };
    }

    private void checkGoal(){
        if (desktop[4][8] == 0){
            desktop[4][8] = 4;
        }
        else if (desktop[4][1] == 0){
            desktop[4][1] = 4;
        }
    }

    private void won() throws Exception {
        boolean isWon = true;
        if (desktop[4][8] != 3 || desktop[4][1] != 3){
            isWon = false;
        }

        if (isWon){
            if (viewer.showDialogWon()){
                desktop = levels.nextLevel();
                viewer.update();
                System.out.println("get next level");
            }
        }
    }

    private void moveUp(){
        if (desktop[indexX - 1][indexY] == 3){
            if (desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4){
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }

        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4){
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveRight(){
        if (desktop[indexX][indexY + 1] == 3){
            if (desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4){
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }

        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4){
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown(){
        if (desktop[indexX + 1][indexY] == 3){
            if (desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4){
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }

        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4){
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveLeft(){
        if (desktop[indexX][indexY - 1] == 3){
            if (desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4){
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }

        if (desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4){
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    public int[][] getDesktop() {
        return desktop;
    }
}
