package by.training.homework1.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipseValidator {
    private static final String REGEX_DOUBLE = "[+-]?\\d+\\.\\d+";
    private static final String FIGURE = "Ellipse";
    private static final String SPACE = "\\s";
    private static final String REGEX_ELLIPSE = "\\b" + FIGURE + ":" +
            SPACE + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + SPACE +
            REGEX_DOUBLE + SPACE + REGEX_DOUBLE + "\\b";

    private static final Logger logger = LogManager.getLogger(EllipseValidator.class);

    public EllipseValidator(){
        logger.debug("EllipseValidator was created.");
    }

    /**
    Method allows you to check whether it is possible
    to create a class object based on the passed data
     */
    public boolean isEllipseData(String data) {
        Pattern pattern = Pattern.compile(REGEX_ELLIPSE);
        Matcher matcher = pattern.matcher(data);
        boolean result = true;

        if (!matcher.find()) {
            result = false;
        }
        logger.debug("Data was checked. Result: " + result);
        return result;
    }
}
