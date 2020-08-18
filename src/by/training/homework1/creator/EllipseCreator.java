package by.training.homework1.creator;

import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;
import by.training.homework1.exception.UserException;
import by.training.homework1.validator.CoordinateValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EllipseCreator {
    public static final Logger logger = LogManager.getLogger(EllipseCreator.class);

    public EllipseCreator(){
        logger.debug("Ellipse creator was created.");
    }

    public List<Ellipse> createEllipsesFromData(List<List<Double>> coordinates)
            throws UserException {
        if (coordinates == null) {
            throw new UserException("Incorrect data...");
        }
        List<Ellipse> ellipses = new ArrayList<>();
        List<CoordinatePoint> points = createCoordinatesEllipse(coordinates);

        for (int i = 0; i < points.size() - 1; i += 2) {
            Ellipse newEllipse = new Ellipse(points.get(i), points.get(i + 1));
            ellipses.add(newEllipse);
        }
        return ellipses;
    }

    public Ellipse createEllipse(CoordinatePoint beginPoint, CoordinatePoint endPoint)
            throws UserException {
        if (beginPoint == null || endPoint == null) {
            throw new UserException("Null-object...");
        }
        CoordinateValidator validator = new CoordinateValidator();
        if (!validator.validatePoint(beginPoint, endPoint)) {
            throw new UserException("Incorrect data...");
        }
        Ellipse ellipse = new Ellipse(beginPoint, endPoint);
        return ellipse;
    }


    private List<CoordinatePoint> createCoordinatesEllipse(List<List<Double>> coordinates) {
        CoordinateValidator validator = new CoordinateValidator();
        List<CoordinatePoint> points = new ArrayList<>();

        for (List<Double> element : coordinates) {
            if (validator.isCoordinatesAmountEllipse(element)
                    || validator.isCoordinatesValid(element)) {
                CoordinatePoint beginPoint = new CoordinatePoint(element.get(0), element.get(1));
                CoordinatePoint endPoint = new CoordinatePoint(element.get(2), element.get(3));
                points.add(beginPoint);
                points.add(endPoint);
            }
        }
        return points;
    }
}
