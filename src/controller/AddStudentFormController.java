package controller;

import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class AddStudentFormController {

    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;


    public JFXTextField txtContactNumber;
    public JFXDatePicker dpDateOfBirth;
    public JFXComboBox cmbGender;
    public JFXTextField txtStudentID;
    public JFXTextField txtSearch;
    public TableView tblStudentDetails;
    public TableColumn colStudentID;
    public TableColumn colStName;
    public TableColumn colAddress;
    public TableColumn colContactNumber;
    public TableColumn colBirth;
    public TableColumn colGender;

    public void btnAddStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }
}
