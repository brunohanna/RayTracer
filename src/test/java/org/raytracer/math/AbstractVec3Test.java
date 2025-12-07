package org.raytracer.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractVec3Test {

    private static final double EPS = 1e-9;

    @Test
    void getX() {
        Vector v = new Vector(1.5, 2.0, 3.0);
        assertEquals(1.5, v.getX(), EPS);
    }

    @Test
    void setX() {
        Vector v = new Vector(0.0, 0.0, 0.0);
        v.setX(4.2);
        assertEquals(4.2, v.getX(), EPS);
    }

    @Test
    void getY() {
        Vector v = new Vector(1.0, -2.5, 3.0);
        assertEquals(-2.5, v.getY(), EPS);
    }

    @Test
    void setY() {
        Vector v = new Vector(0.0, 0.0, 0.0);
        v.setY(-3.7);
        assertEquals(-3.7, v.getY(), EPS);
    }

    @Test
    void getZ() {
        Vector v = new Vector(1.0, 2.0, 7.3);
        assertEquals(7.3, v.getZ(), EPS);
    }

    @Test
    void setZ() {
        Vector v = new Vector(0.0, 0.0, 0.0);
        v.setZ(9.9);
        assertEquals(9.9, v.getZ(), EPS);
    }

    @Test
    void multiplier() {
        Vector v = new Vector(1.0, -2.0, 0.5);

        Vector res = v.multiplier(2.0);

        assertEquals(2.0,  res.getX(), EPS);
        assertEquals(-4.0, res.getY(), EPS);
        assertEquals(1.0,  res.getZ(), EPS);
    }

    @Test
    void testEquals() {
        Vector v1 = new Vector(1.0, 2.0, 3.0);
        Vector v2 = new Vector(1.0, 2.0, 3.0);
        Vector v3 = new Vector(1.0, 2.0, 4.0);
        Point  p  = new Point(1.0, 2.0, 3.0);

        assertTrue(v1.equals(v1));

        assertTrue(v1.equals(v2));
        assertTrue(v2.equals(v1));

        assertFalse(v1.equals(v3));
        assertFalse(v3.equals(v1));

        assertFalse(v1.equals(p));
        assertFalse(p.equals(v1));

        assertFalse(v1.equals(null));
    }
}
