package by.training.homework1.entity;

import by.training.homework1.observer.ObservableEllipse;
import by.training.homework1.observer.ObserverEllipse;
import by.training.homework1.observer.EllipseEvent;

import by.training.homework1.observer.impl.EllipseObserver;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends PlaneFigure implements ObservableEllipse {
    private CoordinatePoint beginPoint;
    private CoordinatePoint endPoint;

    private List<ObserverEllipse> observers;

    private static final Logger logger = LogManager.getLogger(Ellipse.class);

    public Ellipse(CoordinatePoint beginPoint, CoordinatePoint endPoint) {
        super(Type.ELLIPSE);
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
        observers = new ArrayList<>();
        this.attach(new EllipseObserver());
        notifyObservers(new EllipseEvent(this));
    }

    public Ellipse(int id, CoordinatePoint beginPoint, CoordinatePoint endPoint) {
        super(id, Type.ELLIPSE);
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
        observers = new ArrayList<>();
        this.attach(new EllipseObserver());
        notifyObservers(new EllipseEvent(this));
    }


    public CoordinatePoint getBeginPoint() {
        return beginPoint;
    }

    public boolean setBeginPoint(CoordinatePoint beginPoint) {
        if (beginPoint == null ||
                beginPoint.getCoordinateX() >= endPoint.getCoordinateX() ||
                beginPoint.getCoordinateY() <= endPoint.getCoordinateY()) {
            return false;
        }
        this.beginPoint = beginPoint;
        notifyObservers(new EllipseEvent(this));
        return true;
    }

    public CoordinatePoint getEndPoint() {
        return endPoint;
    }

    public boolean setEndPoint(CoordinatePoint endPoint) {
        if (beginPoint == null ||
                beginPoint.getCoordinateX() >= endPoint.getCoordinateX() ||
                beginPoint.getCoordinateY() <= endPoint.getCoordinateY()) {
            return false;
        }
        this.endPoint = endPoint;
        notifyObservers(new EllipseEvent(this));
        return true;
    }

    @Override
    public void attach(ObserverEllipse observer) {
        observers.add(observer);
        logger.debug("Observer was attached.");
    }

    @Override
    public void detach(ObserverEllipse observer) {
        observers.remove(observer);
        logger.debug("Observer was detached.");
    }

    @Override
    public void notifyObservers(EllipseEvent event) {
        observers.forEach(observer -> observer.handleEvent(event));
        logger.debug("Observers were notified.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Ellipse ellipse = (Ellipse) o;

        if (beginPoint != null ? !beginPoint.equals(ellipse.beginPoint) : ellipse.beginPoint != null) {
            return false;
        }
        return endPoint != null ? endPoint.equals(ellipse.endPoint) : ellipse.endPoint == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (beginPoint != null ? beginPoint.hashCode() : 0);
        result = 31 * result + (endPoint != null ? endPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append(", beginPoint: ").append(beginPoint);
        stringBuilder.append(", endPoint: ").append(endPoint);
        return stringBuilder.toString();
    }
}
