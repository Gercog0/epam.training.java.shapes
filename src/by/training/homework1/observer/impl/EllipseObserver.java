package by.training.homework1.observer.impl;

import by.training.homework1.entity.Ellipse;
import by.training.homework1.entity.warehouse.EllipseRecorder;
import by.training.homework1.entity.warehouse.EllipseWareHouse;
import by.training.homework1.observer.ObserverEllipse;
import by.training.homework1.observer.event.EllipseEvent;
import by.training.homework1.service.impl.EllipseServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EllipseObserver implements ObserverEllipse {
    private static final Logger logger = LogManager.getLogger(EllipseObserver.class);

    public EllipseObserver(){
        logger.debug("EllipseObserver was created.");
    }
    @Override
    public void handleEvent(EllipseEvent event) {
        Ellipse ellipse = event.getSource();
        EllipseServiceImpl service = EllipseServiceImpl.createInstance();
        EllipseWareHouse wareHouse = EllipseWareHouse.createInstance();

        double currentPerimeter = service.calculatePerimeter(ellipse);
        double currentSquare = service.calculateSquare(ellipse);

        EllipseRecorder recorder = wareHouse.takeDataById(ellipse.getId());
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
