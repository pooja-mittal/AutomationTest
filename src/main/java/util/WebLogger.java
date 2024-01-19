package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebLogger {

	Logger logger = LogManager.getLogger(WebLogger.class.getName());

	public void info(String message) {
		logger.info(message);
	}

	public void warn(String message) {
		logger.warn(message);
	}

	public void debug(String message) {
		logger.debug(message);
	}

	public void error(String message) {
		logger.error(message);
	}

	public void fatal(String message) {
		logger.fatal(message);
	}

}
