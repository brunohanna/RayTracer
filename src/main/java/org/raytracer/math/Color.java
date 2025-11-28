package org.raytracer.math;

public class Color extends AbstractVec3 {

    public Color(double val1, double val2, double val3) {
        // Valeur comprise entre 0 et 1
        val1 = Double.min(1, val1);
        val1 = Double.max(0, val1);

        val2 = Double.min(1, val2);
        val2 = Double.max(0, val2);

        val3 = Double.min(1, val3);
        val3 = Double.max(0, val3);

        super(val1, val2, val3);
    }

    public void additionner(Color color) {
        this.setX(this.getX() + color.getX());
        this.setY(this.getY() + color.getY());
        this.setZ(this.getZ() + color.getZ());
    }

    public void schur(Color color) {}

    public int toRGB(){
        int red = (int) Math.round(this.getX() * 255);
        int green = (int) Math.round(this.getY() * 255);
        int blue = (int) Math.round(this.getZ() * 255);
        return (
                ((red & 0xff) << 16)
                        + ((green & 0xff) << 8)
                        + (blue & 0xff));
    }
}

