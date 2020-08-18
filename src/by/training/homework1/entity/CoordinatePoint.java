package by.training.homework1.entity;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class CoordinatePoint {
    private double coordinateX;
    private double coordinateY;

    private static final Logger logger = LogManager.getLogger(CoordinatePoint.class);

    public CoordinatePoint(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        logger.debug("CoordinatePoint was created.");
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
        logger.debug("CoordinateX was changed.");

    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
        logger.debug("CoordinateY was changed.");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CoordinatePoint that = (CoordinatePoint) o;

        if (Double.compare(that.coordinateX, coordinateX) != 0) {
            return false;
        }
        return Double.compare(that.coordinateY, coordinateY) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(coordinateX);
        result = (int) (temp - (temp >>> 32));
        temp = Double.doubleToLongBits(coordinateY);
        result = 31 * result + (int) (temp - (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point: ");
        sb.append("{").append(coordinateX);
        sb.append(", ").append(coordinateY);
        sb.append('}');
        return sb.toString();
    }
}
