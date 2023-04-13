package controller;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class DashBoardFormController {
    public StackPane rootHome;

    public void initialize(){


        try {
            StackPane pane = null;
            pane = FXMLLoader.load(this.getClass().getResource("../view/HomePageForm.fxml"));
            rootHome.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        StackPane pane = null;
        pane = FXMLLoader.load(this.getClass().getResource("../view/HomePageForm.fxml"));
        rootHome.getChildren().setAll(pane);

        new FadeIn(rootHome).play();
    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) throws IOException {
        StackPane pane = null;
        pane = FXMLLoader.load(this.getClass().getResource("../view/AddStudentForm.fxml"));
        rootHome.getChildren().setAll(pane);

        new FadeIn(rootHome).play();
    }

    public void btnRoomsOnAction(ActionEvent actionEvent) throws IOException {
        StackPane pane = null;
        pane = FXMLLoader.load(this.getClass().getResource("../view/RoomsForm.fxml"));
        rootHome.getChildren().setAll(pane);

        new FadeIn(rootHome).play();
    }
}
