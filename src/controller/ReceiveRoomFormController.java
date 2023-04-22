package controller;

import bo.BOFactory;
import bo.custom.ReservationBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import entity.Room;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import view.tm.ReceiveRoomTM;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
    public TableColumn ColStatus;
    public JFXComboBox cmbStudentID;

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.RESERVATION);

    public void initialize() {
        txtResID.setText(generateNewID());
        txtResID.setEditable(false);

        loadDate();
        loadRoomDetailCmb();
        loadStudentIDCmb();

        cmbRoomType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getRoomDetails(String.valueOf(newValue));
        });

        cmbStudentID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            getStudentName((String) newValue);
        });

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

    public void btnReceiveRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }
}
