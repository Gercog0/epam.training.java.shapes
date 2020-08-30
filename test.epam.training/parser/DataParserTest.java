package parser;

import by.training.homework1.exception.ProjectException;
import by.training.homework1.parser.DataParser;
import by.training.homework1.reader.DataReader;
import data.DataTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest {
    private DataParser parser;

    @BeforeClass
    public void setUp() {
        parser = new DataParser();
    }

    @Test
    public void parseDataTestValid() throws ProjectException {
        List<List<Double>> expected = DataTest.getInstance().coordinatesToTest();
        List<List<Double>> actual = parser.parseData(new DataReader().readAllData("resources/data.txt"));
        assertEquals(expected, actual);
    }

    @Test
    public void parseDataTestInvalid() throws ProjectException {
        List<List<Double>> expected = new ArrayList<>();
        List<List<Double>> actual = parser.parseData(new DataReader().readAllData("resources/data.txt"));
        assertNotEquals(expected, actual);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}
