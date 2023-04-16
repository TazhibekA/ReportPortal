package core.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	private Log(){}

	private static final Logger LOGGER = LogManager.getLogger("binary_data_logger");

	public static void logInfoMessage(String message){
		LOGGER.info(message);
	}
}
