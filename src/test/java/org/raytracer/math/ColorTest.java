package org.raytracer.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    private static final double EPS = 1e-9;

    @Test
    void color() {
        Color c = new Color();

        assertEquals(0.0, c.getX(), EPS);
        assertEquals(0.0, c.getY(), EPS);
        assertEquals(0.0, c.getZ(), EPS);
    }

    @Test
    void multiplier() {
        Color c = new Color(0.4, 0.5, 0.6);

        Color res = c.multiplier(2.0);

        assertEquals(0.8, res.getX(), EPS);
        assertEquals(1.0, res.getY(), EPS);
        assertEquals(1.0, res.getZ(), EPS);
    }

    @Test
    void addition() {
        Color c1 = new Color(0.7, 0.2, 0.1);
        Color c2 = new Color(0.5, 0.9, 0.3);

        Color res = c1.addition(c2);

        assertEquals(1.0, res.getX(), EPS);
        assertEquals(1.0, res.getY(), EPS);
        assertEquals(0.4, res.getZ(), EPS);
    }

    @Test
    void schur() {
        Color c1 = new Color(0.6, 0.4, 0.5);
        Color c2 = new Color(0.5, 0.5, 0.5);

        Color res = c1.schur(c2);

        assertEquals(0.6 * 0.5, res.getX(), EPS);
        assertEquals(0.4 * 0.5, res.getY(), EPS);
        assertEquals(0.5 * 0.5, res.getZ(), EPS);
    }

    @Test
    void toRGB() {
        Color red = new Color(1.0, 0.0, 0.0);
        Color green = new Color(0.0, 1.0, 0.0);
        Color blue = new Color(0.0, 0.0, 1.0);

        assertEquals(0xFF0000, red.toRGB());
        assertEquals(0x00FF00, green.toRGB());
        assertEquals(0x0000FF, blue.toRGB());
    }
}
