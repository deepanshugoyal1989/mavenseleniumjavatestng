package org.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    public static Logger getLogger() {

        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

    }
}
