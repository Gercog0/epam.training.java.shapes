package by.training.homework1.repository;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.exception.ProjectException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseRepository {
    private static EllipseRepository instance;
    private List<Ellipse> ellipses;

    private EllipseRepository() {
        ellipses = new ArrayList<>();
    }

    public static EllipseRepository getInstance() {
        if (instance == null) {
            instance = new EllipseRepository();
        }
        return instance;
    }

    public List<Ellipse> query(EllipseSpecification specification) {
        List<Ellipse> newEllipses = ellipses.stream().filter(specification).collect(Collectors.toList());
        return newEllipses;
    }

    public List<Ellipse> sort(Comparator<Ellipse> type) {
        List<Ellipse> sortedList = ellipses.stream().sorted(type).collect(Collectors.toList());
        return sortedList;
    }

    public boolean add(Ellipse ellipse) {
        return ellipses.add(ellipse);
    }

    public boolean remove(Ellipse ellipse) {
        return ellipses.remove(ellipse);
    }
}
