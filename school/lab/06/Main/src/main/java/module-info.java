module my.semstral.projectxd.main {
    requires javafx.controls;
    requires javafx.fxml;


    opens my.semstral.projectxd.main to javafx.fxml;
    exports my.semstral.projectxd.main;
}