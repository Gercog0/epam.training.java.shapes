package creator;

import by.training.homework1.creator.EllipseCreator;
import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;
import by.training.homework1.exception.ProjectException;
import data.DataTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class EllipseCreatorTest {
    private EllipseCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new EllipseCreator();
    }

    @Test
    public void createEllipsesFromDataTestValid() {
        try {
            List<List<Double>> dataCoordinates = DataTest.getInstance().coordinatesToTest();
            List<Ellipse> expected = DataTest.getInstance().ellipsesToTest();
            List<Ellipse> actual = creator.createEllipsesFromData(dataCoordinates);
            assertEquals(expected, actual);
        } catch (ProjectException exp) {
            fail("Exception" + exp);
        }
    }

    @Test
    public void createEllipsesFromDataTestInvalid() {
        try {
            List<List<Double>> dataCoordinates = DataTest.getInstance().coordinatesToTest();
            List<Ellipse> expected = new ArrayList<>();
            expected.add(new Ellipse(new CoordinatePoint(4, 5),
                    new CoordinatePoint(3, 9)));
            List<Ellipse> actual = creator.createEllipsesFromData(dataCoordinates);
            assertNotEquals(expected, actual);
        } catch (ProjectException exp) {
            fail("Exception" + exp);
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void createEllipsesFromDataTestException() throws ProjectException {
        creator.createEllipsesFromData(null);
    }

    @Test
    public void createEllipseTestValid() {
        try {
            CoordinatePoint begin = new CoordinatePoint(2, 10);
            CoordinatePoint end = new CoordinatePoint(10, 2);
            Ellipse expected = new Ellipse(1, begin, end);
            Ellipse actual = creator.createEllipse(begin, end);
            assertEquals(expected, actual);
        } catch (ProjectException exp) {
            fail("Exception " + exp);
        }
    }

    @Test
    public void createEllipseTestInvalid() {
        try {
            CoordinatePoint begin = new CoordinatePoint(2, 10);
            CoordinatePoint end = new CoordinatePoint(10, 2);
            Ellipse expected = new Ellipse(begin, end);
            Ellipse actual = creator.createEllipse(begin, new CoordinatePoint(7, 5));
            assertNotEquals(expected, actual);
        } catch (ProjectException exp) {
            fail("Exception " + exp);
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void createEllipseTestException() throws ProjectException {
        creator.createEllipse(null, null);
    }

    @AfterClass
    public void tierDown() {
        creator = null;
    }
}
