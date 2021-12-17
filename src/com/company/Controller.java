package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    private Model model;

    public Controller(Viewer viewer){
        model = new Model(viewer);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode){
            case 37:
                try {
                    model.move("Left");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 38:
                try {
                    model.move("Up");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 39:
                try {
                    model.move("Right");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 40:
                try {
                    model.move("Down");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                return;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Model getModel() {
        return model;
    }
}
