package controller;

import bo.BOFactory;
import bo.custom.ReservationBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.ReservationDTO;
import entity.Room;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ReceiveRoomTM;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ReceiveRoomFormController {
    public JFXTextField txtResID;
    public JFXTextField txtStudentName;
    public JFXComboBox cmbRoomType;
    public JFXTextField txtRoomID;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQTY;
    public JFXTextField txtStatus;
    public JFXTextField txtDate;
    public TableView<ReceiveRoomTM> tblReceiveRoomDetails;
    public TableColumn colReceiveID;
    public TableColumn colDate;
    public TableColumn colStudentID;
    public TableColumn colRoomID;
    public TableColumn colStatus;
    public JFXComboBox cmbStudentID;

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.RESERVATION);

    public void initialize() {
        txtResID.setText(generateNewID());
        txtResID.setEditable(false);

        loadDate();
        loadRoomDetailCmb();
        loadStudentIDCmb();
        getAllReceiveDetails();

        colReceiveID.setCellValueFactory(new PropertyValueFactory<>("res_ID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("resDate"));
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        cmbRoomType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getRoomDetails(String.valueOf(newValue));
        });

        cmbStudentID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getStudentName((String) newValue);
        });

    }

    private void getAllReceiveDetails() {
        tblReceiveRoomDetails.getItems().clear();

        try {
            ArrayList<ReservationDTO> allReceive = reservationBO.getAllDetails();
            for (ReservationDTO dto : allReceive) {
                tblReceiveRoomDetails.getItems().add(new ReceiveRoomTM(
                   dto.getRes_ID(),
                   dto.getResDate(),
                   dto.getStudentID(),
                   dto.getRoomID(),
                   dto.getStatus()
                ));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void getStudentName(String newValue) {
        try {
            String studentName = new StudentDAOImpl().getStudentName(newValue);
            txtStudentName.setText(studentName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getRoomDetails(String newValue) {
        try {
            Room roomDetails = new RoomDAOImpl().getRoomDetails(newValue);
            txtRoomID.setText(roomDetails.getRoom_type_id());
            txtKeyMoney.setText(String.valueOf(roomDetails.getKey_money()));
            txtRoomQTY.setText(String.valueOf(roomDetails.getQty()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadRoomDetailCmb() {

        try {
            List<String> rooms = new RoomDAOImpl().getRoomType();
            cmbRoomType.getItems().addAll(rooms);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadStudentIDCmb() {
        try {
            List<String> studentID = new StudentDAOImpl().getStudentID();
            cmbStudentID.getItems().addAll(studentID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        txtDate.setText(format.format(date));
        txtDate.setEditable(false);
    }

    private String generateNewID() {
        try {
            return reservationBO.generateNewID();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (tblReceiveRoomDetails.getItems().isEmpty()) {
            return "RS001";
        } else {
            String id = getLastDetailID();
            int newDetailID = Integer.parseInt(id.replace("RS", "")) + 1;
            return String.format("RS%03d", newDetailID);
        }
    }

    private String getLastDetailID() {
        List<ReceiveRoomTM> tmList = new ArrayList<>(tblReceiveRoomDetails.getItems());
        Collections.sort(tmList);
        return tmList.get(tmList.size() - 1).getRes_ID();
    }

    private void clear() {
        txtResID.clear();
        cmbStudentID.getItems().clear();
        txtStudentName.clear();
        cmbRoomType.getItems().clear();
        txtRoomID.clear();
        txtKeyMoney.clear();
        txtRoomQTY.clear();
        txtStatus.clear();
    }

    public void btnReceiveRoomOnAction(ActionEvent actionEvent) {
        String resID = txtResID.getText();
        LocalDate date = LocalDate.parse(txtDate.getText());
        String studentID = (String) cmbStudentID.getValue();
        String roomID = txtRoomID.getText();
        String status = txtStatus.getText();

        try {
            if (reservationBO.addReservation(new ReservationDTO(
                   resID,
                   date,
                   studentID,
                   roomID,
                   status
            ))) {
                clear();
                new Alert(Alert.AlertType.INFORMATION, "Added...!").show();
                getAllReceiveDetails();
                txtResID.setText(generateNewID());
                loadRoomDetailCmb();
                loadStudentIDCmb();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the Reservation " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }
}
