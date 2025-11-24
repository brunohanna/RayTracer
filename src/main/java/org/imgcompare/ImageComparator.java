package org.imgcompare;

import java.awt.image.BufferedImage;

public class ImageComparator {

    public int countDifferentPixels(BufferedImage imgA, BufferedImage imgB) {
        int width = imgA.getWidth();
        int height = imgA.getHeight();
        int diffCount = 0;

        // Double boucle pixel par pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int rgbA = imgA.getRGB(x, y);
                int rgbB = imgB.getRGB(x, y);

                if (rgbA != rgbB) {
                    diffCount++;
                }
            }
        }
        return diffCount;
    }

    public BufferedImage generateDiffImage(BufferedImage imgA, BufferedImage imgB) {
        int width = imgA.getWidth();
        int height = imgA.getHeight();

        // Création de l'image
        BufferedImage diff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Double boucle pixel par pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int rgbA = imgA.getRGB(x, y);
                int rgbB = imgB.getRGB(x, y);

                if (rgbA == rgbB) {
                    // pixel noir
                    diff.setRGB(x, y, 0x000000);
                } else {
                    // imgA
                    int ra = (rgbA >> 16) & 0xFF;
                    int ga = (rgbA >> 8) & 0xFF;
                    int ba = rgbA & 0xFF;

                    // imgB
                    int rb = (rgbB >> 16) & 0xFF;
                    int gb = (rgbB >> 8) & 0xFF;
                    int bb = rgbB & 0xFF;

                    // Calculer la différence absolue
                    int rd = Math.abs(ra - rb);
                    int gd = Math.abs(ga - gb);
                    int bd = Math.abs(ba - bb);

                    // reconstruire un pixel RGB pour l’image diff
                    int rgbDiff = (rd << 16) | (gd << 8) | bd;

                    diff.setRGB(x, y, rgbDiff);
                }
            }
        }
        return diff;
    }

}