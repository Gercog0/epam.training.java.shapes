package by.training.homework1.comparator;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.entity.warehouse.EllipseWareHouse;

import java.util.Comparator;

public enum ComparatorType {
    ID((ellipse1, ellipse2) -> ellipse1.getId() - ellipse2.getId()),
    BEGIN_POINT_X((ellipse1, ellipse2) -> Double.compare(ellipse1.getBeginPoint().getCoordinateX(),
            ellipse2.getBeginPoint().getCoordinateX())),
    BEGIN_POINT_Y((ellipse1, ellipse2) -> Double.compare(ellipse1.getBeginPoint().getCoordinateY(),
            ellipse2.getBeginPoint().getCoordinateY())),
    END_POINT_X((ellipse1, ellipse2) -> Double.compare(ellipse1.getEndPoint().getCoordinateX(),
            ellipse2.getEndPoint().getCoordinateX())),
    END_POINT_Y((ellipse1, ellipse2) -> Double.compare(ellipse1.getEndPoint().getCoordinateY(),
            ellipse2.getEndPoint().getCoordinateY())),
    PERIMETER((ellipse1, ellipse2) -> Double.compare(EllipseWareHouse.createInstance().
                    takeDataById(ellipse1.getId()).getPerimeter(),
            EllipseWareHouse.createInstance().takeDataById(ellipse2.getId()).getPerimeter())),
    SQUARE((ellipse1, ellipse2) -> Double.compare(EllipseWareHouse.createInstance().
                    takeDataById(ellipse1.getId()).getSquare(),
            EllipseWareHouse.createInstance().takeDataById(ellipse2.getId()).getSquare()));

    private final Comparator<Ellipse> comparator;

    ComparatorType(Comparator<Ellipse> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Ellipse> getComparator() {
        return comparator;
    }
}
