package controller;

import animatefx.animation.ZoomIn;
import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddStudentFormController {

    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;


    public JFXTextField txtContactNumber;
    public JFXDatePicker dpDateOfBirth;
    public JFXComboBox cmbGender;
    public JFXTextField txtStudentID;
    public JFXTextField txtSearch;
    public TableView<StudentTM> tblStudentDetails;
    public TableColumn colStudentID;
    public TableColumn colStName;
    public TableColumn colAddress;
    public TableColumn colContactNumber;
    public TableColumn colBirth;
    public TableColumn colGender;

    private final StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.STUDENT);

    public void initialize() {
        txtStudentID.setText(generateNewID());
        txtStudentID.setEditable(false);



        colStudentID.setCellValueFactory(new PropertyValueFactory<>("student_ID"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        loadAllStudents();
        cmbLoad();
    }

    private void cmbLoad() {
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");
    }

    private void loadAllStudents() {
        tblStudentDetails.getItems().clear();
        try {
            ArrayList<StudentDTO> allStudent = studentBO.findAll();
            for (StudentDTO dto : allStudent) {
                tblStudentDetails.getItems().add(new StudentTM(
                        dto.getStudent_ID(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact_no(),
                        dto.getDob(),
                        dto.getGender()
                ));
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private String generateNewID() {
        try {
            return studentBO.generateNewID();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (tblStudentDetails.getItems().isEmpty()) {
            return "S001";
        } else {
            String id = getLastStudentID();
            int newStudentID = Integer.parseInt(id.replace("S", "")) + 1;
            return String.format("S%03d", newStudentID);
        }
    }

    private String getLastStudentID() {
        List<StudentTM> tempStudentList = new ArrayList<>(tblStudentDetails.getItems());
        Collections.sort(tempStudentList);
        return tempStudentList.get(tempStudentList.size() - 1).getStudent_ID();
    }

    boolean existStudent(String id) throws SQLException, ClassNotFoundException {
        return studentBO.ifStudentExist(id);
    }

    private void clear() {
        txtStudentID.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtContactNumber.clear();
        dpDateOfBirth.setValue(null);
        cmbGender.getItems().clear();
    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String address = txtAddress.getText();
        String contact = txtContactNumber.getText();
        String dob = String.valueOf(dpDateOfBirth.getValue());
        String gender = (String) cmbGender.getValue();

        try {
            if (existStudent(id)) {
                new Alert(Alert.AlertType.ERROR, id + "Already Exists").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION,  "Saved...!").show();

                clear();
                StudentDTO studentDTO = new StudentDTO(id, name, address, contact, dob, gender);
                studentBO.addStudent(studentDTO);
                loadAllStudents();
                txtStudentID.setText(generateNewID());
                cmbLoad();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the student " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        StudentTM selectedStudent = tblStudentDetails.getSelectionModel().getSelectedItem();
        txtStudentID.setText(selectedStudent.getStudent_ID());
        txtStudentName.setText(selectedStudent.getName());
        txtAddress.setText(selectedStudent.getAddress());
        txtContactNumber.setText(selectedStudent.getContact_no());
        dpDateOfBirth.setValue(LocalDate.parse(selectedStudent.getDob()));
        cmbGender.setValue(selectedStudent.getGender());
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }
}
