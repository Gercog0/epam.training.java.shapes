package repository;

import by.training.homework1.comparator.ComparatorType;
import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;
import by.training.homework1.repository.EllipseRepository;
import by.training.homework1.repository.EllipseSpecification;
import by.training.homework1.repository.impl.SearchByFirstQuadrantSpecification;
import by.training.homework1.repository.impl.SearchByIdSpecification;
import by.training.homework1.repository.impl.SearchByPerimeterBetweenSpecification;
import by.training.homework1.repository.impl.SearchBySquareBetweenSpecification;
import data.DataTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EllipseRepositoryTest {
    private EllipseRepository repository;

    @BeforeClass
    public void setUp() {
        repository = EllipseRepository.getInstance();
        List<Ellipse> ellipses = DataTest.getInstance().ellipsesToTest();
        for (Ellipse ellipse : ellipses) {
            repository.add(ellipse);
        }
    }

    @DataProvider(name = "dataSpecificationAndResultValid")
    public Object[][] createDataSpecificationValid() {
        List<Ellipse> quadrantSpec = new ArrayList<>();
        Ellipse ellipse4 = new Ellipse(4, new CoordinatePoint(1.33, 12.20),
                new CoordinatePoint(7.40, 1.65));
        quadrantSpec.add(ellipse4);

        List<Ellipse> idSpec = new ArrayList<>();
        Ellipse ellipse1 = new Ellipse(1, new CoordinatePoint(5.23, -2.20),
                new CoordinatePoint(7.40, -9.65));
        idSpec.add(ellipse1);

        List<Ellipse> perimeterSpec = new ArrayList<>();
        perimeterSpec.add(ellipse4);

        List<Ellipse> squareSpec = new ArrayList<>();
        squareSpec.add(ellipse1);

        return new Object[][]{
                {new SearchByFirstQuadrantSpecification(), quadrantSpec},
                {new SearchByIdSpecification(1), idSpec},
                {new SearchByPerimeterBetweenSpecification(20, 30), perimeterSpec},
                {new SearchBySquareBetweenSpecification(0, 30), squareSpec},
        };
    }

    @DataProvider(name = "dataSpecificationAndResultInvalid")
    public Object[][] createDataSpecificationInvalid() {
        List<Ellipse> quadrantSpec = new ArrayList<>();
        Ellipse ellipse4 = new Ellipse(6, new CoordinatePoint(1.33, 12.20),
                new CoordinatePoint(7.40, 1.65));
        quadrantSpec.add(ellipse4);

        List<Ellipse> idSpec = new ArrayList<>();
        Ellipse ellipse1 = new Ellipse(1, new CoordinatePoint(5.23, -2.20),
                new CoordinatePoint(7.40, -9.65));
        idSpec.add(ellipse4);

        List<Ellipse> perimeterSpec = new ArrayList<>();
        perimeterSpec.add(ellipse1);

        List<Ellipse> squareSpec = new ArrayList<>();
        squareSpec.add(ellipse4);

        return new Object[][]{
                {new SearchByFirstQuadrantSpecification(), quadrantSpec},
                {new SearchByIdSpecification(1), idSpec},
                {new SearchByPerimeterBetweenSpecification(20, 30), perimeterSpec},
                {new SearchBySquareBetweenSpecification(0, 30), squareSpec},
        };
    }

    @Test(dataProvider = "dataSpecificationAndResultValid")
    public void queryTestValid(EllipseSpecification specification, List<Ellipse> expected) {
        List<Ellipse> actual;
        actual = repository.query(specification);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "dataSpecificationAndResultInvalid")
    public void queryTestInvalid(EllipseSpecification specification, List<Ellipse> expected) {
        List<Ellipse> actual;
        actual = repository.query(specification);
        assertNotEquals(expected, actual);
    }

    @Test
    public void sortTestValid() {
        Comparator<Ellipse> comparator = ComparatorType.ID.getComparator();
        List<Ellipse> expected = DataTest.getInstance().ellipsesToTest();
        List<Ellipse> actual = repository.sort(comparator);
        assertEquals(expected, actual);
    }

    @Test
    public void sortTestInvalid() {
        Comparator<Ellipse> comparator = ComparatorType.END_POINT_X.getComparator();
        List<Ellipse> expected = DataTest.getInstance().ellipsesToTest();
        List<Ellipse> actual = repository.sort(comparator);
        assertNotEquals(expected, actual);
    }

    @AfterClass
    public void tierDown() {
        repository = null;
    }
}
