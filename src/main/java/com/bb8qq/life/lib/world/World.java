package com.bb8qq.life.lib.world;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class World {

    private final int width;
    private final int height;

    private int[][] pointsA;
    private int[][] pointsB;
    private boolean isStep;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        pointsA = new int[width][height];
        pointsB = new int[width][height];

    }

    /**
     * Сброс
     *
     * @param random
     */
    public void reset(Random random) {
        this.isStep = true;
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                pointsA[w][h] = random.nextInt(2);
            }
        }
    }

    /**
     * Расчет нового шага.
     *
     * @param out
     */
    public void nextStep(BufferedImage out) {
        int c, r;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (isStep) {
                    r = calc(pointsA, x, y);
                    pointsB[x][y] = r;
                } else {
                    r = calc(pointsB, x, y);
                    pointsA[x][y] = r;
                }
                if (r == 1) {
                    c = new Color(0, 0, 0).getRGB();
                } else {
                    c = new Color(255, 255, 255).getRGB();
                }
                out.setRGB(x, y, c);
            }
        }
        isStep = !isStep;
    }

    private int calc(int[][] a, int x, int y) {
        int sum = 0;


        if (x > 0
                && x < width - 1
                && y > 0
                && y < height - 1
        ) {
            sum = a[x - 1][y - 1] + a[x][y - 1] + a[x + 1][y - 1]
                    + a[x - 1][y] + a[x + 1][y]
                    + a[x + 1][y - 1] + a[x + 1][y] + a[x + 1][y + 1];

        } else {
            sum = new Random().nextInt(5);
        }



        if (sum == 3) {
            return 1;
        } else if (sum == 2) {
            return a[x][y];
        }
        return 0;
    }


}
