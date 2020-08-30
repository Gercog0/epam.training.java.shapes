package service;

import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;
import by.training.homework1.service.impl.EllipseServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseServiceImplTest {
    EllipseServiceImpl service;

    @BeforeClass
    public void setUp() {
        service = EllipseServiceImpl.getInstance();
    }

    @Test
    public void calculatePerimeterTestValid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);

        double expected = 25.132741228718345;
        double actual = service.calculatePerimeter(ellipse);
        assertEquals(expected, actual);
    }

    @Test
    public void calculatePerimeterTestInvalid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);

        double expected = 30;
        double actual = service.calculatePerimeter(ellipse);
        assertNotEquals(expected, actual);
    }

    @Test
    public void calculateSquareTestValid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);

        double expected = 50.26548245743669;
        double actual = service.calculateSquare(ellipse);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSquareTestInvalid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);

        double expected = 30;
        double actual = service.calculateSquare(ellipse);
        assertNotEquals(expected, actual);
    }

    @Test
    public void isCrossOxTestValid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, -2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean condition = service.isCrossOx(ellipse);
        assertTrue(condition);
    }

    @Test
    public void isCrossOxTestInvalid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean condition = service.isCrossOx(ellipse);
        assertFalse(condition);
    }

    @Test
    public void isCrossOyTestValid() {
        CoordinatePoint begin = new CoordinatePoint(-2, 10);
        CoordinatePoint end = new CoordinatePoint(10, -2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean condition = service.isCrossOy(ellipse);
        assertTrue(condition);
    }

    @Test
    public void isCrossOyTestInvalid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);
        boolean condition = service.isCrossOy(ellipse);
        assertFalse(condition);
    }

    @Test
    public void isCircleTestValid() {
        CoordinatePoint begin = new CoordinatePoint(2, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);

        boolean condition = service.isCircle(ellipse);
        assertTrue(condition);
    }

    @Test
    public void isCircleTestInvalid() {
        CoordinatePoint begin = new CoordinatePoint(3, 10);
        CoordinatePoint end = new CoordinatePoint(10, 2);
        Ellipse ellipse = new Ellipse(begin, end);

        boolean condition = service.isCircle(ellipse);
        assertFalse(condition);
    }

    @AfterClass
    public void tierDown() {
        service = null;
    }
}
