package by.training.homework1.repository.specification.impl;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.entity.warehouse.EllipseRecorder;
import by.training.homework1.entity.warehouse.EllipseWareHouse;
import by.training.homework1.repository.specification.EllipseSpecification;

public class SearchByPerimeterBetweenSpecification implements EllipseSpecification {
    private double from;
    private double to;

    public SearchByPerimeterBetweenSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean test(Ellipse ellipse) {
        EllipseWareHouse wareHouse = EllipseWareHouse.createInstance();
        EllipseRecorder ellipseRecorder = wareHouse.takeDataById(ellipse.getId());
        double ovalPerimeter = ellipseRecorder.getPerimeter();
        return ovalPerimeter >= from && ovalPerimeter <= to;
    }
}