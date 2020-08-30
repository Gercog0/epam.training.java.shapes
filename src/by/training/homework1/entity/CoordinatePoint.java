package by.training.homework1.entity;

public class CoordinatePoint {
    private double coordinateX;
    private double coordinateY;

    public CoordinatePoint(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
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
