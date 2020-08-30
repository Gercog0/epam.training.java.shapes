package by.training.homework1.observer;

import by.training.homework1.entity.Ellipse;

import java.util.EventObject;

public class EllipseEvent extends EventObject {

    public EllipseEvent(Ellipse inputSource) {
        super(inputSource);
    }

    public Ellipse getSource() {
        return (Ellipse) super.getSource();
    }
}
