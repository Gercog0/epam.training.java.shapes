package data;

import by.training.homework1.entity.CoordinatePoint;
import by.training.homework1.entity.Ellipse;

import java.util.ArrayList;
import java.util.List;

public class DataTest {
    private static DataTest instance;

    private DataTest() {
    }

    public static DataTest getInstance() {
        if (instance == null) {
            instance = new DataTest();
        }
        return instance;
    }

    public List<List<Double>> coordinatesToTest() {
        List<Double> first = new ArrayList<>();
        first.add(5.23);
        first.add(-2.20);
        first.add(7.40);
        first.add(-9.65);

        List<Double> second = new ArrayList<>();
        second.add(0.0);
        second.add(10.0);
        second.add(10.0);
        second.add(0.0);

        List<Double> third = new ArrayList<>();
        third.add(17.93);
        third.add(22.11);
        third.add(72.41);
        third.add(-19.12);

        List<Double> fourth = new ArrayList<>();
        fourth.add(1.33);
        fourth.add(12.20);
        fourth.add(7.40);
        fourth.add(1.65);

        List<List<Double>> coordinates = new ArrayList<>();
        coordinates.add(first);
        coordinates.add(second);
        coordinates.add(third);
        coordinates.add(fourth);

        return coordinates;
    }

    public List<Ellipse> ellipsesToTest() {
        CoordinatePoint begin1 = new CoordinatePoint(5.23, -2.20);
        CoordinatePoint end1 = new CoordinatePoint(7.40, -9.65);
        Ellipse ellipse1 = new Ellipse(1, begin1, end1);

        CoordinatePoint begin2 = new CoordinatePoint(0.0, 10.0);
        CoordinatePoint end2 = new CoordinatePoint(10.0, 0);
        Ellipse ellipse2 = new Ellipse(2, begin2, end2);

        CoordinatePoint begin3 = new CoordinatePoint(17.93, 22.11);
        CoordinatePoint end3 = new CoordinatePoint(72.41, -19.12);
        Ellipse ellipse3 = new Ellipse(3, begin3, end3);

        CoordinatePoint begin4 = new CoordinatePoint(1.33, 12.20);
        CoordinatePoint end4 = new CoordinatePoint(7.40, 1.65);
        Ellipse ellipse4 = new Ellipse(4, begin4, end4);

        List<Ellipse> ellipses = new ArrayList<>();
        ellipses.add(ellipse1);
        ellipses.add(ellipse2);
        ellipses.add(ellipse3);
        ellipses.add(ellipse4);

        return ellipses;
    }

}
