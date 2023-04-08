package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtHidePassword;
    public JFXTextField txtShowPassword;
    public ImageView imgShowPasswordClick;
    public ImageView imgHidePasswordClick;
    public AnchorPane root;

    String password;



    public void initialize(){
        txtShowPassword.setVisible(false);
        imgHidePasswordClick.setVisible(false);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"));
        Scene scene = new Scene(parent);

        Stage primaryStage = (Stage) this.root.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void imgShowEyerClick(MouseEvent mouseEvent) {
        txtShowPassword.setVisible(true);
        imgHidePasswordClick.setVisible(true);

        txtHidePassword.setVisible(false);
        imgShowPasswordClick.setVisible(false);
    }

    public void imgHideEyerClick(MouseEvent mouseEvent) {
        txtHidePassword.setVisible(true);
        imgShowPasswordClick.setVisible(true);

        txtShowPassword.setVisible(false);
        imgHidePasswordClick.setVisible(false);
    }

    public void HidePasswordOnAction(KeyEvent actionEvent) {
        password = txtHidePassword.getText();
        txtShowPassword.setText(password);
    }

    public void ShowPasswordOnAction(KeyEvent actionEvent) {
        password = txtShowPassword.getText();
        txtHidePassword.setText(password);
    }
}
