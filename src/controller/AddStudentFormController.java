package controller;

import animatefx.animation.ZoomIn;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

public class AddStudentFormController {
    public Pane pnRoomResDetails;
    public Pane pnStudentDetails;

    public void btnViewStudentDetails(ActionEvent actionEvent) {
        pnStudentDetails.setVisible(true);
        new ZoomIn(pnStudentDetails).play();
        pnRoomResDetails.setVisible(false);
    }

    public void btnViewResDetails(ActionEvent actionEvent) {
        pnRoomResDetails.setVisible(true);
        new ZoomIn(pnRoomResDetails).play();
        pnStudentDetails.setVisible(false);
    }
}
