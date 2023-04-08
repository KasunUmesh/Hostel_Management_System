package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtHidePassword;
    public JFXTextField txtShowPassword;
    public ImageView imgShowPasswordClick;
    public ImageView imgHidePasswordClick;

    String password;



    public void initialize(){
        txtShowPassword.setVisible(false);
        imgHidePasswordClick.setVisible(false);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
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
