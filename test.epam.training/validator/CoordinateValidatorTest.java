package validator;

import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.validator.CoordinateValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CoordinateValidatorTest {
    CoordinateValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new CoordinateValidator();
    }

    @DataProvider(name = "dataPointsValid")
    public Object[][] createDataPointsValid() {
        return new Object[][]{
                {new CoordinatePoint(5.23, -2.20),
                        new CoordinatePoint(7.40, -9.65)},
                {new CoordinatePoint(0.0, 10.0),
                        new CoordinatePoint(10.0, 0.0)},
                {new CoordinatePoint(17.93, 22.11),
                        new CoordinatePoint(72.41, -19.12)},
        };
    }

    @DataProvider(name = "dataPointsInvalid")
    public Object[][] createDataPointsInvalid() {
        return new Object[][]{
                {new CoordinatePoint(7.40, -9.65),
                        new CoordinatePoint(7.40, -2.20)},
                {new CoordinatePoint(20.1, 40.0),
                        new CoordinatePoint(10.0, 40.0)},
                {new CoordinatePoint(-10000, 22.11),
                        new CoordinatePoint(72.41, -19.12)},
        };
    }

    @Test(dataProvider = "dataPointsValid")
    public void validatePointTestValid(CoordinatePoint beginPoint, CoordinatePoint endPoint) {
        boolean condition = validator.validatePoint(beginPoint, endPoint);
        assertTrue(condition);
    }

    @Test(dataProvider = "dataPointsInvalid")
    public void validatePointTestInvalid(CoordinatePoint beginPoint, CoordinatePoint endPoint) {
        boolean condition = validator.validatePoint(beginPoint, endPoint);
        assertFalse(condition);
    }

    @Test
    public void isCoordinatesTestValid(){
        List<Double> values = new ArrayList<>();
        values.add(5.23);
        values.add(-2.20);
        values.add(7.40);
        values.add(-9.65);
        boolean condition = validator.isCoordinatesValid(values);
        assertTrue(condition);

    }

    @Test
    public void isCoordinatesTestInvalid(){
        List<Double> values = new ArrayList<>();
        values.add(1005.23);
        values.add(-2323.20);
        values.add(732.40);
        values.add(-933.65);
        boolean condition = validator.isCoordinatesValid(values);
        assertFalse(condition);

    }

    @AfterClass
    public void tierDown() {
        validator = null;
    }
}
