package by.training.homework1.entity;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;

public class EllipseWareHouse {
    private static EllipseWareHouse instance;

    private Map<Integer, EllipseRecorder> data;

    private static final Logger logger = LogManager.getLogger(EllipseWareHouse.class);

    private EllipseWareHouse() {
        data = new HashMap<>();
    }

    public static EllipseWareHouse getInstance() {
        if (instance == null) {
            instance = new EllipseWareHouse();
        }
        return instance;
    }

    public EllipseRecorder getData(int id) {
        EllipseRecorder recorder = data.get(id);
        return recorder;
    }

    public void add(int id, EllipseRecorder parameters) {
        data.put(id, parameters);
        logger.debug("Successful addition");
    }

    public void remove(int id) {
        data.remove(id);
        logger.debug("Successful removing");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("EllipseWareHouse\n");
        sb.append(data);
        return sb.toString();
    }
}
