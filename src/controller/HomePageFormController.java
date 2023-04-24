package controller;

import dao.custom.impl.ReservationDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class HomePageFormController {
    public PieChart pieChartRoom;
    public Label lblRoomCount;
    public Label lblStudentCount;
    public Label lblBookedRoom;

    public void initialize() {

        setCount();

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Non-AC",20),
                new PieChart.Data("Non-AC-Food",30),
                new PieChart.Data("AC",10),
                new PieChart.Data("AC-Food",40)
        );

        pieChartRoom.setData(pieChartData);
        pieChartRoom.setTitle("Available Rooms QTY");
    }

    public void setCount() {
        try {
            lblStudentCount.setText(String.valueOf(new StudentDAOImpl().studentCount()));
            lblRoomCount.setText(String.valueOf(new RoomDAOImpl().roomCount()));
            lblBookedRoom.setText(String.valueOf(new ReservationDAOImpl().reservationCount()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
