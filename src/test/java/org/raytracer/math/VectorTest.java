package org.raytracer.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    private static final double EPS = 1e-9;

    @Test
    void multiplier() {
        Vector v = new Vector(1, -2, 0.5);

        Vector res = v.multiplier(2.0);

        assertEquals(2.0,  res.getX(), EPS);
        assertEquals(-4.0, res.getY(), EPS);
        assertEquals(1.0,  res.getZ(), EPS);

        Vector v2 = new Vector(1, 2, 3);

        Vector res2 = v2.multiplier(3.0);

        assertEquals(1.0, v2.getX(), EPS);
        assertEquals(2.0, v2.getY(), EPS);
        assertEquals(3.0, v2.getZ(), EPS);

        assertEquals(3.0, res2.getX(), EPS);
        assertEquals(6.0, res2.getY(), EPS);
        assertEquals(9.0, res2.getZ(), EPS);
    }

    @Test
    void soustraction2Points() {
        Point p1 = new Point(4, 3, 2);
        Point p2 = new Point(1, 1, 1);

        Vector v = new Vector(0, 0, 0);
        v.soustraction2Points(p1, p2);

        assertEquals(3.0, v.getX(), EPS);
        assertEquals(2.0, v.getY(), EPS);
        assertEquals(1.0, v.getZ(), EPS);
    }

    @Test
    void addition() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, -1, 0);

        Vector res = v1.addition(v2);

        assertEquals(5.0, res.getX(), EPS);
        assertEquals(1.0, res.getY(), EPS);
        assertEquals(3.0, res.getZ(), EPS);

        Point p = new Point(1.0, 2.0, 3.0);
        Vector v = new Vector(4.0, -1.0, 2.0);

        AbstractVec3 result = v.addition(p);

        assertInstanceOf(Point.class, result);

        Point res2 = (Point) result;

        assertEquals(5.0, res2.getX(), EPS);
        assertEquals(1.0, res2.getY(), EPS);
        assertEquals(5.0, res2.getZ(), EPS);

        assertEquals(4.0, v.getX(), EPS);
        assertEquals(-1.0, v.getY(), EPS);
        assertEquals(2.0, v.getZ(), EPS);
    }

    @Test
    void scalaire() {
        Vector v1 = new Vector(1, 0, 0);
        Vector v2 = new Vector(0, 1, 0);

        double dot = v1.scalaire(v2);

        assertEquals(0.0, dot, EPS);

        Vector v3 = new Vector(2, 0, 0);
        Vector v4 = new Vector(3, 0, 0);

        double dot2 = v3.scalaire(v4);

        assertEquals(6.0, dot2, EPS);
    }

    @Test
    void vectoriel() {
        Vector v1 = new Vector(1, 0, 0);
        Vector v2 = new Vector(0, 1, 0);

        Vector res = v1.vectoriel(v2);

        assertEquals(0.0, res.getX(), EPS);
        assertEquals(0.0, res.getY(), EPS);
        assertEquals(1.0, res.getZ(), EPS);

        Vector v3 = new Vector(1, 2, 3);
        Vector v4 = new Vector(2, 4, 6);

        Vector res2 = v3.vectoriel(v4);

        assertEquals(0.0, res2.getX(), EPS);
        assertEquals(0.0, res2.getY(), EPS);
        assertEquals(0.0, res2.getZ(), EPS);
    }

    @Test
    void longueur() {
        Vector v = new Vector(3, 4, 0);

        double len = v.longueur();

        assertEquals(5.0, len, EPS);

        Vector v2 = new Vector(0, 0, 1);

        double len2 = v2.longueur();

        assertEquals(1.0, len2, EPS);
    }

    @Test
    void normalisation() {
        Vector v = new Vector(1, 2, 3);

        Vector n = v.normalisation();

        double len = n.longueur();

        assertEquals(1.0, len, 1e-8);

        double expectedLen = v.longueur();
        assertEquals(v.getX() / expectedLen, n.getX(), 1e-8);
        assertEquals(v.getY() / expectedLen, n.getY(), 1e-8);
        assertEquals(v.getZ() / expectedLen, n.getZ(), 1e-8);

        Vector v2 = new Vector(0, 1, 0);

        Vector n2 = v2.normalisation();

        assertEquals(0.0, n2.getX(), EPS);
        assertEquals(1.0, n2.getY(), EPS);
        assertEquals(0.0, n2.getZ(), EPS);
    }
}