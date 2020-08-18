package by.training.homework1.service.impl;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.service.EllipseService;
import org.apache.log4j.Logger;

public class EllipseServiceImpl implements EllipseService {
    private static EllipseServiceImpl instance;

    private static final Logger logger = Logger.getLogger(EllipseServiceImpl.class);

    private EllipseServiceImpl() {
        logger.debug("EllipseServiceImpl was created.");
    }

    public static EllipseServiceImpl createInstance() {
        if (instance == null) {
            instance = new EllipseServiceImpl();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter(Ellipse ellipse) {
        double perimeter = 2 * Math.PI *
                Math.sqrt((Math.pow((ellipse.getEndPoint().getCoordinateX()
                        - ellipse.getBeginPoint().getCoordinateX()) / 2, 2)
                        + Math.pow((ellipse.getBeginPoint().getCoordinateY()
                        - ellipse.getEndPoint().getCoordinateY()) / 2, 2)) / 2);
        logger.debug("Perimeter calculated: {}" + perimeter);
        return perimeter;
    }

    @Override
    public double calculateSquare(Ellipse ellipse) {
        double square = Math.PI
                * (ellipse.getEndPoint().getCoordinateX()
                - ellipse.getBeginPoint().getCoordinateX()) / 2
                * (ellipse.getBeginPoint().getCoordinateY()
                - ellipse.getEndPoint().getCoordinateY()) / 2;
        logger.debug("Square calculated: {}" + square);
        return square;
    }

    @Override
    public boolean isCrossOx(Ellipse ellipse) {
        boolean isCross = Double.compare(ellipse.getBeginPoint().getCoordinateY(), 0.0) >= 0
                && Double.compare(ellipse.getEndPoint().getCoordinateY(), 0.0) <= 0;
        return isCross;
    }

    @Override
    public boolean isCrossOy(Ellipse ellipse) {
        boolean isCross = Double.compare(ellipse.getBeginPoint().getCoordinateX(), 0.0) <= 0
                && Double.compare(ellipse.getEndPoint().getCoordinateX(), 0.0) >= 0;
        return isCross;
    }

    @Override
    public boolean isCircle(Ellipse ellipse) {
        boolean isCircle = (ellipse.getEndPoint().getCoordinateX() -
                ellipse.getBeginPoint().getCoordinateX()) / 2
                == (ellipse.getBeginPoint().getCoordinateY() -
                ellipse.getEndPoint().getCoordinateY()) / 2;
        return isCircle;
    }
}
