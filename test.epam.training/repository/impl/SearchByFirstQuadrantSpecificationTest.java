package repository.impl;

import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;
import by.training.homework1.repository.impl.SearchByFirstQuadrantSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchByFirstQuadrantSpecificationTest {
    @Test
    public void SearchByFirstQuadrantSpecificationTestValid() {
        Ellipse ellipse = new Ellipse(
                new CoordinatePoint(5, 5),
                new CoordinatePoint(10, 1)
        );

        boolean condition = new SearchByFirstQuadrantSpecification().test(ellipse);
        assertTrue(condition);
    }

    @Test
    public void SearchByFirstQuadrantSpecificationTestInvalid() {
        Ellipse ellipse = new Ellipse(
                new CoordinatePoint(-5, 5),
                new CoordinatePoint(10, 0)
        );

        boolean condition = new SearchByFirstQuadrantSpecification().test(ellipse);
        assertFalse(condition);
    }
}
