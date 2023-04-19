package controller;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public StackPane rootHome;
    public StackPane rootFullPage;

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

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/LoginForm.fxml"));
        Scene scene = new Scene(parent);

        Stage stage = new Stage();
        Stage stage1 = (Stage) this.rootFullPage.getScene().getWindow();
        stage1.close();

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }
}
