package com.bb8qq.life;

import com.bb8qq.life.lib.world.MyGraphJPanel;

import javax.swing.*;
import java.awt.*;

public class MainLa extends JFrame {

    public MainLa() throws HeadlessException {
        super("TITLE");
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyGraphJPanel graphJPanel = new MyGraphJPanel(this);
        getContentPane().add(graphJPanel);

        pack();
        setSize(512, 512);

    }
}
