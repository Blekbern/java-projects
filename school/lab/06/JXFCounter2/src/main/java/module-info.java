module cz.cvut.fel.pjv {
    requires javafx.controls;
    requires javafx.fxml;

    opens cz.cvut.fel.pjv to javafx.fxml;
    exports cz.cvut.fel.pjv;
}