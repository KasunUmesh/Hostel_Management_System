package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class RoomsController {
    public JFXTextField txtRoomTypeID;
    public JFXComboBox cmbRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQTY;

    private final RoomBO roomBO = BOFactory.getInstance().getBO(BOFactory.BOType.ROOM);

    public void initialize() {
        cmbRoomType.getItems().add("Non-AC");
        cmbRoomType.getItems().add("Non-AC / Food");
        cmbRoomType.getItems().add("AC");
        cmbRoomType.getItems().add("AC / Food");
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
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }
}
