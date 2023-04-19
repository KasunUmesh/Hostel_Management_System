package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class HomePageFormController {
    public PieChart pieChartRoom;

    public void initialize() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Non-AC",20),
                new PieChart.Data("Non-AC-Food",30),
                new PieChart.Data("AC",10),
                new PieChart.Data("AC-Food",40)
        );

        pieChartRoom.setData(pieChartData);
        pieChartRoom.setTitle("Available Rooms QTY");
    }
}
