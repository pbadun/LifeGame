package com.bb8qq.life.lib.world;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MyGraphJPanel extends JPanel implements ActionListener {
    private JFrame frame;
    private Random random = new Random();
    private Timer timer = new Timer(1, this);
    private World world;

    private final int width = 128;
    private final int height = 128;

    public MyGraphJPanel(JFrame jFrame) {
        this.frame = jFrame;
        timer.start();
        world = new World(width, height);
        world.reset(random);
    }

    public void paint(Graphics g) {
        g.drawImage(ee(), 0, 0, frame.getWidth() - 10, frame.getHeight() - 40, null);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    private BufferedImage ee() {
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        world.nextStep(output);
        return output;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
