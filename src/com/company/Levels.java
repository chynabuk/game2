package com.company;

public class Levels {
    private int level;

    public Levels() {
        this.level = 7;
    }

    public int[][] nextLevel() throws Exception {
        int[][] desktop;

        switch (level){
            case 1:
                desktop = getFirstLevel();
                break;
            case 2:
                desktop = getSecondLevel();
                break;
            case 3:
                desktop = getThirdLevel();
                break;
            case 4:
                desktop = getFileLevel("level4.txt");
                break;
            case 5:
                desktop = getFileLevel("level5.txt");
                break;
            case 6:
                desktop = getFileLevel("level6.txt");
                break;
            case 7:
                desktop = getServerLevel(7);
                break;
            case 8:
                desktop = getServerLevel(8);
                break;
            case 9:
                desktop = getServerLevel(9);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }

        level++;

        return desktop;
    }

    private int[][] getFirstLevel() throws Exception {
        FileRead fileLevel = new FileRead("level4.txt");
        return fileLevel.getContentInTwoDimensionArray();
    }
    private int[][] getSecondLevel() throws Exception {
        FileRead fileLevel = new FileRead("level4.txt");
        return fileLevel.getContentInTwoDimensionArray();
    }

    private int[][] getThirdLevel() throws Exception {
        FileRead fileLevel = new FileRead("level4.txt");
        return fileLevel.getContentInTwoDimensionArray();
    }

    private int[][] getFileLevel(String level) throws Exception {
        FileRead fileLevel = new FileRead(level);
        return fileLevel.getContentInTwoDimensionArray();
    }

    private int[][] getServerLevel(int lvl){
        ServerLevel serverLevel = new ServerLevel();
        int[][] serverDesktop = serverLevel.getDataFromServer(lvl).getDesktop();
        return serverDesktop;
    }
}
