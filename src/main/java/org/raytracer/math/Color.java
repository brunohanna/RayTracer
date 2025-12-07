package org.raytracer.math;
import org.jetbrains.annotations.NotNull;

public class Color extends AbstractVec3 {

    public Color() {
        double val1 = 0.0, val2 = 0.0, val3 = 0.0;
        super(val1, val2, val3);
    }

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

    @Override
    public Color multiplier(double d) {
        return new Color(
                Math.min(1,this.getX() * d),
                Math.min(1,this.getY() * d),
                Math.min(1,this.getZ() * d)
        );
    }

    /**
     * Addition de deux couleurs
     * @param color (la couleur à additionner)
     * return (r1, g1, b1) + (r2, g2, b2) = (r1+r2, g1+g2, b1+b2)
     */
    public Color addition(@NotNull Color color) {
        return new Color(
            this.getX() + color.getX(),
            this.getY() + color.getY(),
            this.getZ() + color.getZ()
        );
    }

    /**
     * Produit de Schur de deux couleurs
     * @param color
     * return (r1, g1, b1) * (r2, g2, b2) = (r1*r2, g1*g2, b1*b2)
     */
    public Color schur(@NotNull Color color) {
        return new Color(
                this.getX() * color.getX(),
                this.getY() * color.getY(),
                this.getZ() * color.getZ()
        );
    }

    /**
     * Conversion Color 0-1 à 0-255
     * @return (0xr*255, 0xg*255, 0xb*255)
     */
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

