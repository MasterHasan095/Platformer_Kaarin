package com.example.platformer.main;

import com.example.platformer.inputs.KeyboardInputs;
import com.example.platformer.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;

    private int x = 100;
    private int y = 100;
    private BufferedImage img, subImg;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importing();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void importing() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            img = ImageIO.read(is);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void changeXDelta(int value){
        this.x += value;
    }
    public void changeYDelta(int value){
        this.y += value;
    }

    public void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        subImg = img.getSubimage(1*64, 8*40, 64, 40);
        g.drawImage(subImg, x, y, 128, 80, null);
    }


}
