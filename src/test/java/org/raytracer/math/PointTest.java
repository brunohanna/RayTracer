package org.raytracer.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private static final double EPS = 1e-9;

    @Test
    void multiplier() {
        Point p = new Point(1.0, -2.0, 0.5);

        Point res = p.multiplier(2.0);

        assertEquals(2.0,  res.getX(), EPS);
        assertEquals(-4.0, res.getY(), EPS);
        assertEquals(1.0,  res.getZ(), EPS);

        assertEquals(1.0, p.getX(), EPS);
        assertEquals(-2.0, p.getY(), EPS);
        assertEquals(0.5, p.getZ(), EPS);
    }

    @Test
    void soustraction() {
        Point p1 = new Point(4.0, 3.0, 2.0);
        Point p2 = new Point(1.0, 1.0, 1.0);

        AbstractVec3 result = p1.soustraction(p2);

        assertInstanceOf(Vector.class, result);

        Vector v = (Vector) result;

        assertEquals(3.0, v.getX(), EPS);
        assertEquals(2.0, v.getY(), EPS);
        assertEquals(1.0, v.getZ(), EPS);

        assertEquals(4.0, p1.getX(), EPS);
        assertEquals(3.0, p1.getY(), EPS);
        assertEquals(2.0, p1.getZ(), EPS);

        assertEquals(1.0, p2.getX(), EPS);
        assertEquals(1.0, p2.getY(), EPS);
        assertEquals(1.0, p2.getZ(), EPS);
    }

    @Test
    void addition() {
        Point p = new Point(1.0, 2.0, 3.0);
        Vector v = new Vector(4.0, -1.0, 2.0);

        AbstractVec3 result = p.addition(v);

        assertInstanceOf(Point.class, result);

        Point res = (Point) result;

        assertEquals(5.0, res.getX(), EPS);
        assertEquals(1.0, res.getY(), EPS);
        assertEquals(5.0, res.getZ(), EPS);

        assertEquals(1.0, p.getX(), EPS);
        assertEquals(2.0, p.getY(), EPS);
        assertEquals(3.0, p.getZ(), EPS);
    }

}
