package by.training.homework1.repository.specification.impl;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.repository.specification.EllipseSpecification;

public class SearchByFirstQuadrantSpecification implements EllipseSpecification {
    @Override
    public boolean test(Ellipse ellipse) {
        return ellipse.getBeginPoint().getCoordinateX() > 0 &&
                ellipse.getEndPoint().getCoordinateY() > 0;
    }
}
