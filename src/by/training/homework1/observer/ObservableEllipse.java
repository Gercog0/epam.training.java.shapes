package by.training.homework1.observer;

public interface ObservableEllipse {
    void attach(ObserverEllipse observer);

    void detach(ObserverEllipse observer);

    void notifyObservers(EllipseEvent event);
}
