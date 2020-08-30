package by.training.homework1.repository.impl;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.entity.EllipseRecorder;
import by.training.homework1.entity.EllipseWareHouse;
import by.training.homework1.repository.EllipseSpecification;

public class SearchBySquareBetweenSpecification implements EllipseSpecification {
    private double from;
    private double to;

    public SearchBySquareBetweenSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean test(Ellipse ellipse) {
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();
        EllipseRecorder ellipseRecorder = wareHouse.getData(ellipse.getId());
        double ovalSquare = ellipseRecorder.getSquare();
        return ovalSquare >= from && ovalSquare <= to;
    }
}
