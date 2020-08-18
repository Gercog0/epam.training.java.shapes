package by.training.homework1.repository;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.exception.UserException;
import by.training.homework1.repository.specification.EllipseSpecification;

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

    public static EllipseRepository createInstance() {
        if (instance == null) {
            instance = new EllipseRepository();
        }
        return instance;
    }

    public List<Ellipse> query(EllipseSpecification specification) {
        List<Ellipse> newEllipses = ellipses.stream().filter(specification).collect(Collectors.toList());
        return newEllipses;
    }

    public List<Ellipse> sort(Comparator<Ellipse> type) throws UserException {
        if (type == null) {
            throw new UserException("Incorrect data...");
        }
        List<Ellipse> sortedList = ellipses.stream().sorted(type).collect(Collectors.toList());
        return sortedList;
    }

    boolean add(Ellipse ellipse) throws UserException {
        if (ellipse == null) {
            throw new UserException("Incorrect data...");
        }
        return ellipses.add(ellipse);
    }

    boolean remove(Ellipse ellipse) throws UserException {
        if (ellipse == null) {
            throw new UserException("Incorrect data...");
        }
        return ellipses.remove(ellipse);
    }
}
