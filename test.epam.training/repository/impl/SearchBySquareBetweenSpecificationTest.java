package repository.impl;

import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;
import by.training.homework1.repository.impl.SearchBySquareBetweenSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SearchBySquareBetweenSpecificationTest {
    @Test
    public void SearchBySquareBetweenSpecificationTestValid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(40, begin, end);

        boolean condition = new SearchBySquareBetweenSpecification(50, 60).test(ellipse);
        assertTrue(condition);
    }

    @Test
    public void SearchBySquareBetweenSpecificationTestInvalid() {
        CoordinatePoint begin = new CoordinatePoint(22, 99.9);
        CoordinatePoint end = new CoordinatePoint(56, 99);
        Ellipse ellipse = new Ellipse(41, begin, end);

        boolean condition = new SearchBySquareBetweenSpecification(20, 21).test(ellipse);
        assertFalse(condition);
    }
}
