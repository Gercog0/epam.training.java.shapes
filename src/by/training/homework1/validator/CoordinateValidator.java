package by.training.homework1.validator;

import by.training.homework1.entity.CoordinatePoint;

import java.util.List;

public class CoordinateValidator {
    private static final int MAX_COORDINATE = 1000;
    private static final int MIN_COORDINATE = -1000;

    public boolean validatePoint(CoordinatePoint beginPoint, CoordinatePoint endPoint) {
        boolean condition = validateValuesPoint(beginPoint) && validateValuesPoint(endPoint)
                && isCoordinatesAmountEllipse(beginPoint, endPoint);
        return condition;
    }

    /**
     * Method allows you to check whether the passed
     * coordinates of points do not exceed the set limits
     */
    public boolean isCoordinatesValid(List<Double> coordinates) {
        for (double element : coordinates) {
            if (!validateValue(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method allows you to check whether the specified point
     * coordinates are correct for creating an ellipse.
     */
    public boolean isCoordinatesAmountEllipse(List<Double> coordinates) {
        boolean condition = !(coordinates.get(0) == coordinates.get(2)
                || coordinates.get(1) == coordinates.get(3));
        return condition;
    }

    public boolean isCoordinatesAmountEllipse(CoordinatePoint beginPoint, CoordinatePoint endPoint) {
        boolean condition = !(beginPoint.getCoordinateX() == endPoint.getCoordinateX()
                || beginPoint.getCoordinateY() == endPoint.getCoordinateY());
        return condition;
    }

    private boolean validateValuesPoint(CoordinatePoint point) {
        return validateValue(point.getCoordinateX()) && validateValue(point.getCoordinateY());
    }

    private boolean validateValue(double doubleValue) {
        return doubleValue < MAX_COORDINATE && doubleValue > MIN_COORDINATE;
    }
}
