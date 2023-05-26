module my.semestral.projectxd.yump {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens my.semestral.projectxd.yump to javafx.fxml;
    exports my.semestral.projectxd.yump;
    exports my.semestral.projectxd.yump.View;
}