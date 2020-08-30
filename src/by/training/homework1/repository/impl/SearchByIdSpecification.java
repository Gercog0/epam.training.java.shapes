package by.training.homework1.repository.impl;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.repository.EllipseSpecification;

public class SearchByIdSpecification implements EllipseSpecification {
    private int searchId;

    public SearchByIdSpecification(int searchId) {
        this.searchId = searchId;
    }

    @Override
    public boolean test(Ellipse ellipse) {
        return ellipse.getId() == searchId;
    }
}
