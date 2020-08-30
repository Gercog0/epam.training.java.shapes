package repository.impl;

import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;
import by.training.homework1.repository.impl.SearchByIdSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchByIdSpecificationTest {
    @Test
    public void SearchByIdSpecificationTestValid() {
        Ellipse ellipse = new Ellipse(1,
                new CoordinatePoint(5, 5),
                new CoordinatePoint(10, 1)
        );

        boolean condition = new SearchByIdSpecification(1).test(ellipse);
        assertTrue(condition);
    }

    @Test
    public void SearchByIdSpecificationTestInvalid() {
        Ellipse ellipse = new Ellipse(
                new CoordinatePoint(5, 5),
                new CoordinatePoint(10, 1)
        );

        boolean condition = new SearchByIdSpecification(-1).test(ellipse);
        assertFalse(condition);
    }
}
