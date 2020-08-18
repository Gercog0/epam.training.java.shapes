package by.training.homework1.observer;

import by.training.homework1.observer.event.EllipseEvent;

public interface ObservableEllipse {
    void attach(ObserverEllipse observer);

    void detach(ObserverEllipse observer);

    void notifyObservers(EllipseEvent event);
}
