package com.bb8qq.life;

import com.bb8qq.life.lib.Log;
import com.bb8qq.life.lib.world.MyGraphJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static boolean bQuit = false;

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainLa.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainLa().setVisible(true);
            }
        });
    }


    private void ee() {
        Log.p("Start");
        JFrame frame = new JFrame("JustGame");
        MyGraphJPanel main = new MyGraphJPanel(frame);
        frame.add(main);
        frame.setSize(1024, 1024);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bQuit = true;
                System.exit(0);
            }
        });
        frame.setVisible(true);

        while (!bQuit) {
            try {
                Thread.sleep(1000l);
            } catch (Exception e) {
            }
        }
        Log.p("End");
    }
}
