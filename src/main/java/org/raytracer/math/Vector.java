package org.raytracer.math;
import org.jetbrains.annotations.NotNull;

public class Vector extends AbstractVec3 {

    public Vector(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public Vector multiplier(double d) {
        return new Vector(this.getX() * d, this.getY() * d, this.getZ() * d);
    }

    /**
     * Soustraction de deux points
     * @param point1
     * @param point2
     * return (Px1-Px2, Py1-Py2, Pz1-Pz2)
     */
    public void soustraction2Points(@NotNull Point point1, @NotNull Point point2) {
        this.setX(point1.getX() - point2.getX());
        this.setY(point1.getY() - point2.getY());
        this.setZ(point1.getZ() - point2.getZ());
    }

    /**
     * Addition de vecteurs
     * @param vector
     * return (x1, y1, z1) + (x2, y2, z2) = (x1+x2, y1+y2, z1+z2)
     */
    public Vector addition(@NotNull Vector vector) {
        return new Vector(
                this.getX() + vector.getX(),
                this.getY() + vector.getY(),
                this.getZ() + vector.getZ()
        );
    }

    /**
     * Produit Scolaire
     * @param vector
     * @return double = (x1*x2 + y1*y2 + z1*z2)
     */
    public double scalaire(@NotNull Vector vector) {
        return (
                this.getX() * vector.getX()
                        + this.getY() * vector.getY()
                        + this.getZ() * vector.getZ()
        );
    }

    /**
     * Produit Vectoriel
     * @param vector
     * @return (y1∗z2 − z1∗y2, z1∗x2 − x1∗z2, x1∗y2 − y1∗x2)
     */
    public Vector vectoriel(@NotNull Vector vector) {
        return new Vector(
                this.getY() * vector.getZ() - this.getZ() * vector.getY(),
                this.getZ() * vector.getX() - this.getX() * vector.getZ(),
                this.getX() * vector.getY() - this.getY() * vector.getX()
        );
    }

    /**
     * Longueur d'un vecteur
     * @return (x,y,z) = sqrt(x,y,z)
     */
    public double longueur() {
        return (
                Math.sqrt(scalaire(this))
        );
    }

    /**
     * Normalisation d'un vecteur
     * @return (x1,y1,z1) = sqrt(x1,y1,z1)
     */

}
