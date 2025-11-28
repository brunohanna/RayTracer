package org.raytracer.math;

public abstract class AbstractVec3 {
    private double x;
    private double y;
    private double z;

    public AbstractVec3(double val1, double val2, double val3) {
        this.x = val1;
        this.y = val2;
        this.z = val3;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Multiplication Scalaire
     * @param d (le scalaire)
     * @return d*(x, y, z) = (d*x, d*y, d*z)
     */
    public void multiplier(double d){
        this.x *= d;
        this.y *= d;
        this.z *= d;
    }
}
