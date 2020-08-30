package by.training.homework1.observer.impl;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.entity.EllipseRecorder;
import by.training.homework1.entity.EllipseWareHouse;
import by.training.homework1.observer.ObserverEllipse;
import by.training.homework1.observer.EllipseEvent;
import by.training.homework1.service.impl.EllipseServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EllipseObserver implements ObserverEllipse {
    private static final Logger logger = LogManager.getLogger(EllipseObserver.class);

    @Override
    public void handleEvent(EllipseEvent event) {
        Ellipse ellipse = event.getSource();
        EllipseServiceImpl service = EllipseServiceImpl.getInstance();
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();

        double currentPerimeter = service.calculatePerimeter(ellipse);
        double currentSquare = service.calculateSquare(ellipse);

        EllipseRecorder recorder = wareHouse.getData(ellipse.getId());
        if (recorder == null) {
            recorder = new EllipseRecorder(currentPerimeter, currentSquare);
        } else {
            recorder.setPerimeter(currentPerimeter);
            recorder.setSquare(currentSquare);
        }
        wareHouse.add(ellipse.getId(), recorder);
        logger.debug("Data was updated.");
    }
}
