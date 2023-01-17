package com.todolist;

import com.todolist.config.Log4jConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.function.LongBinaryOperator;


public class Main {
    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Log4jConfigurator.configure();

        LOGGER.info("Starting application");
        User james = new User("j@gmail.com", "James", "Bond", LocalDate.of(1990, 1, 1), "paSsword9");

        LOGGER.debug("{} {}", james.getFname(), james.todoList);
        LOGGER.debug("{}", LocalDate.now());
    }
}
