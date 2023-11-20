package com.example.platformer.main;

import com.example.platformer.inputs.KeyboardInputs;
import com.example.platformer.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir =0.3f, yDir = 0.3f;
    private int frames = 0;
    private Long lastCheck = 0L;
    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRectangle();

        g.setColor(new Color(150, 20, 90  ));
        g.fillRect((int)xDelta, (int)yDelta, 200, 50);

    }

    public void updateRectangle(){
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0){
            xDir *= -1;
        }
        yDelta += yDir;
        if (yDelta > 400 || yDelta < 00){
            yDir *= -1;
        }
    }

    public void changeXDelta(int value){
        this.xDelta += value;
    }
    public void changeYDelta(int value){
        this.yDelta += value;
    }

    public void setRectPos(int x , int y){
        this.xDelta =x;
        this.yDelta = y;
    }
}
