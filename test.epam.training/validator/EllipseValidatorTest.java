package validator;

import by.training.homework1.validator.EllipseValidator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseValidatorTest {
    private EllipseValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new EllipseValidator();
    }

    @DataProvider(name = "dataEllipseValid")
    public Object[][] dataEllipseValid() {
        return new Object[][]{
                {"Ellipse: 5.23 -2.20 7.40 -9.65"},
                {"Ellipse: 0.0 10.0 10.0 0.0"},
                {"Ellipse: 1.33 12.20 7.40 1.65"},
                {"Ellipse: 90.45 90.22 190.54 0.13"},
                {"Ellipse: 17.93 22.11 72.41 -19.12"},
        };
    }

    @DataProvider(name = "dataEllipseInvalid")
    public Object[][] dataEllipseInvalid() {
        return new Object[][]{
                {"Oval: 12.33 122.20 7.40 4.65"},
                {"Ellipse: 5.23 -2.20"},
                {"Ellipse: 5.23 -2.20 7.40 "},
                {"O: 11.1 34.1 56.40 14.45",},
                {"Ellipse: 5.23s -2.a20 7.40 -9.65"},
        };
    }

    @Test(dataProvider = "dataEllipseValid")
    public void isEllipseDataTestValid(String data) {
        boolean condition = validator.isEllipseData(data);
        assertTrue(condition);
    }

    @Test(dataProvider = "dataEllipseInvalid")
    public void isEllipseDataTestInvalid(String data) {
        boolean condition = validator.isEllipseData(data);
        assertFalse(condition);
    }

    @AfterClass
    public void tierDown() {
        validator = null;
    }
}
