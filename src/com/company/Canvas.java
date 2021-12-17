package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {
    private Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;

    public Canvas(Model model){
        this.model = model;
        setBackground(Color.BLACK);
        setOpaque(true);
        File fileNameImageGamer = new File("images/gamer.png");
        File fileNameImageWall = new File("images/wall.png");
        File fileNameImageBox = new File("images/box.png");
        File fileNameImageGoal = new File("images/goal.png");

        try {
            imageGamer = ImageIO.read(fileNameImageGamer);
            imageWall = ImageIO.read(fileNameImageWall);
            imageBox = ImageIO.read(fileNameImageBox);
            imageGoal = ImageIO.read(fileNameImageGoal);
        }
        catch (IOException ioe){
            System.out.println(ioe);
        }
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        int start = 50;
        int x = start;
        int y = start;
        int width = 50;
        int height = 50;
        int offset = 1;

        int[][] desktop = model.getDesktop();
        for (int i = 0; i < desktop.length; i++){
            for (int j = 0; j < desktop[i].length; j++){
                if (desktop[i][j] == 1){
                    graphics.drawImage(imageGamer, x, y, null);
                }

                else if (desktop[i][j] == 2){
                    graphics.drawImage(imageWall, x, y, null);
                }
                else if (desktop[i][j] == 3){
                    graphics.drawImage(imageBox, x, y, null);
                }
                else if (desktop[i][j] == 4){
                    graphics.drawImage(imageGoal, x, y, null);
                }

                x = x + width + offset;
            }

            x = start;
            y = y + height + offset;
        }
    }
}
