module fr.afpa {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.afpa to javafx.fxml;
    exports fr.afpa;
    exports fr.afpa.controller;
    opens fr.afpa.controller to javafx.fxml;
    exports fr.afpa.utils;
    opens fr.afpa.utils to javafx.fxml;
}