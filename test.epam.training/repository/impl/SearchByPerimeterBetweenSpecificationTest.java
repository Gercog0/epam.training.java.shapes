package repository.impl;

import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;
import by.training.homework1.repository.impl.SearchByPerimeterBetweenSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchByPerimeterBetweenSpecificationTest {
    @Test
    public void SearchByPerimeterBetweenSpecificationTestValid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(40, begin, end);

        boolean condition = new SearchByPerimeterBetweenSpecification(20, 30).test(ellipse);
        assertTrue(condition);
    }

    @Test
    public void SearchByPerimeterBetweenSpecificationTestInvalid() {
        CoordinatePoint begin = new CoordinatePoint(22, 99.9);
        CoordinatePoint end = new CoordinatePoint(56, 99);
        Ellipse ellipse = new Ellipse(41, begin, end);

        boolean condition = new SearchByPerimeterBetweenSpecification(20, 30).test(ellipse);
        assertFalse(condition);
    }
}
