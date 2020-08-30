package by.training.homework1.entity;

public class EllipseRecorder{
    private double perimeter;
    private double square;

    public EllipseRecorder(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EllipseRecorder that = (EllipseRecorder) o;

        if (Double.compare(that.perimeter, perimeter) != 0) {
            return false;
        }
        return Double.compare(that.square, square) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = 1;
        temp = Double.doubleToLongBits(perimeter);
        result = 31 * result + (int) (temp - (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = 31 * result + (int) (temp - (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("perimeter: ").append(perimeter);
        sb.append(", square: ").append(square);
        return sb.toString();
    }
}
