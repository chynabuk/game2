package com.company;

import javax.swing.*;

public class Viewer {
    private Canvas canvas;
    private JFrame frame;

    public Viewer(){
        Controller controller = new Controller(this);
        canvas = new Canvas(controller.getModel());
        frame = new JFrame("Sokoban Game MVC Pattern");
        frame.setSize(700, 700);
        frame.add("Center", canvas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }

    public void update(){
        canvas.repaint();
    }

    public boolean showDialogWon(){
        JOptionPane.showMessageDialog(frame, "You are wooon!!!!");
        return true;
    }
}
