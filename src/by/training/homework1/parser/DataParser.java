package by.training.homework1.parser;

import by.training.homework1.validator.EllipseValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {
    private static final String REGEX_DELIMITER = "\\s+";

    private static final Logger logger = LogManager.getLogger(DataParser.class);

    public DataParser() {
        logger.debug("Data parser was created.");
    }

    public List<List<Double>> parseData(List<String> lines) {
        List<List<Double>> ellipsesData = new ArrayList<>();
        EllipseValidator validator = new EllipseValidator();

        for (String line : lines) {
            if (validator.isEllipseData(line)) {
                List<Double> coordinates = takeCoordinatesFromLine(line);
                ellipsesData.add(coordinates);
            }
        }
        logger.debug("Data was parsing successful.");
        return ellipsesData;
    }

    private List<Double> takeCoordinatesFromLine(String line) {
        List<Double> coordinates = new ArrayList<>();
        List<String> strings = Arrays.asList(line.split(REGEX_DELIMITER));
        for (int i = 1; i < strings.size(); i++) {
            coordinates.add(Double.parseDouble(strings.get(i)));
        }
        return coordinates;
    }
}
