package by.training.homework1.service;

import by.training.homework1.entity.Ellipse;

public interface EllipseService {
    double calculatePerimeter(Ellipse ellipse);
    double calculateSquare(Ellipse ellipse);
    boolean isCrossOx(Ellipse ellipse);
    boolean isCrossOy(Ellipse ellipse);
    boolean isCircle(Ellipse ellipse);
}
