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
    private Timer timer = new Timer(100, this);
    private World world;

    private final int width = 64;
    private final int height = 64;

    public MyGraphJPanel(JFrame jFrame) {
        this.frame = jFrame;
        timer.start();
        world = new World(width, height);
        world.reset(random);
    }

    public void paint(Graphics g) {
        g.drawImage(ee(), 0, 0, frame.getWidth() - 10, frame.getHeight() - 10, null);
    }

    private BufferedImage ee() {
        BufferedImage output = new BufferedImage(width, height + 1, BufferedImage.TYPE_INT_ARGB);
        world.nextStep(output);
        return output;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
