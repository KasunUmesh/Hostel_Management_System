package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.RoomTM;

import java.util.List;

public class RoomsController {
    public JFXTextField txtRoomTypeID;
    public JFXComboBox cmbRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQTY;

    private final RoomBO roomBO = BOFactory.getInstance().getBO(BOFactory.BOType.ROOM);
    public TableView<RoomTM> tblRoomDetails;
    public TableColumn colRoomTypeID;
    public TableColumn colRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomQty;

    public void initialize() {
        cmbRoomType.getItems().add("Non-AC");
        cmbRoomType.getItems().add("Non-AC / Food");
        cmbRoomType.getItems().add("AC");
        cmbRoomType.getItems().add("AC / Food");

        findAll();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colRoomTypeID.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }


    private void findAll() {
        ObservableList<RoomTM> tmList = FXCollections.observableArrayList();
        List<RoomDTO> all = roomBO.findAll();
        for (RoomDTO dto : all) {
            RoomTM tm = new RoomTM(
                    dto.getRoom_type_id(),
                    dto.getRoom_type(),
                    dto.getKey_money(),
                    dto.getQty()
            );
            tmList.add(tm);
        }
        tblRoomDetails.setItems(tmList);
    }

    public void btnAddRoomOnAction(ActionEvent actionEvent) {
        String id = txtRoomTypeID.getText();
        String roomType = (String) cmbRoomType.getValue();
        double keyMoney = Double.parseDouble(txtKeyMoney.getText());
        int roomQTY = Integer.parseInt(txtRoomQTY.getText());

        if (roomBO.add(new RoomDTO(
                id,
                roomType,
                keyMoney,
                roomQTY
        ))) {
            txtRoomTypeID.setText(null);
            cmbRoomType.getItems().clear();
            txtKeyMoney.setText(null);
            txtRoomQTY.setText(null);
            new Alert(Alert.AlertType.INFORMATION, "Added...!").show();
            findAll();
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtRoomTypeID.getText();
        String roomType = (String) cmbRoomType.getValue();
        double keyMoney = Double.parseDouble(txtKeyMoney.getText());
        int roomQTY = Integer.parseInt(txtRoomQTY.getText());

        if (roomBO.update(new RoomDTO(
                id,
                roomType,
                keyMoney,
                roomQTY
        ))) {
            txtRoomTypeID.setText(null);
            cmbRoomType.setValue("");
            txtKeyMoney.setText(null);
            txtRoomQTY.setText(null);
            new Alert(Alert.AlertType.INFORMATION, "Updated...!").show();
            findAll();
        } else {
            new Alert(Alert.AlertType.ERROR, "Something Wrong").show();
        }

    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        RoomTM selectedRoom = tblRoomDetails.getSelectionModel().getSelectedItem();
        txtRoomTypeID.setText(selectedRoom.getRoom_type_id());
        cmbRoomType.setValue(selectedRoom.getRoom_type());
        txtKeyMoney.setText(String.valueOf(selectedRoom.getKey_money()));
        txtRoomQTY.setText(String.valueOf(selectedRoom.getQty()));
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {

        String id = tblRoomDetails.getSelectionModel().getSelectedItem().getRoom_type_id();

        boolean roomDelete = roomBO.delete(id);

        if (roomDelete) {
            new Alert(Alert.AlertType.CONFIRMATION,"Delete Successfully", ButtonType.OK).show();
            findAll();

        } else {
            new Alert(Alert.AlertType.WARNING,"Delete Error",ButtonType.OK).show();
        }

    }
}
