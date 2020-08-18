package by.training.homework1.observer.event;

import by.training.homework1.entity.Ellipse;

public class EllipseEvent {
    private Ellipse source;

    public EllipseEvent(Ellipse inputSource) {
        source = inputSource;
    }

    public Ellipse getSource() {
        return source;
    }
}
