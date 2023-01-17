module com.todolist {
    requires org.slf4j;
    requires log4j;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.todolist to javafx.fxml;

    exports com.todolist;
    exports com.todolist.controller;
    opens com.todolist.controller to javafx.fxml;
}