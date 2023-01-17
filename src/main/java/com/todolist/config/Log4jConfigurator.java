package com.todolist.config;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Log4jConfigurator {
    public static void configure() {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);

        ConsoleAppender appender = new ConsoleAppender();
        appender.setTarget("System.out");
        appender.setLayout(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"));
        appender.activateOptions();
        rootLogger.addAppender(appender);
    }

    private Log4jConfigurator() {
        throw new IllegalStateException("Utility class");
    }
}
