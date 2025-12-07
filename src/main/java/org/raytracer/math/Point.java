package org.raytracer.math;
import org.jetbrains.annotations.NotNull;

public class Point extends AbstractVec3 {
    public Point(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public Point multiplier(double d) {
        return new Point(this.getX() * d, this.getY() * d, this.getZ() * d);
    }

    /**
     * Soustraction Point
     * @param point
     * @return new Vector (x1-x2, y1-y2, z1-z2)
     */
    public Vector soustraction(@NotNull Point point) {
        return new Vector(
            this.getX() - point.getX(),
            this.getY() - point.getY(),
            this.getZ() - point.getZ());
    }
}
