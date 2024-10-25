package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    // Initialize the Log4j logger
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    // Custom logging methods (optional, for simplicity)
    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void trace(String message) {
        logger.trace(message);
    }
}
