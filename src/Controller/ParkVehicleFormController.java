package Controller;

import View.tm.DriverTM;
import View.tm.VehicleTM;
import db.Database;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Driver;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

public class ParkVehicleFormController {
    public AnchorPane ParkVehicleContext;
    public ComboBox cmbSelectVehicle;
    public ComboBox cmbDriver;
    public TextField txtVehicleType;
    public Label lblDateAndTime;
    public Label lblSlot;

    public Vehicle setVehicle;

    public void initialize(){

        loadData();
        currentDateTime();

        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            findVehicle(newValue);

            txtVehicleType.setText(setVehicle.getVehicleType());
            findSlot();

        });


    }
    private void findSlot() {
        switch (setVehicle.getVehicleType()){
            case "Van" : {
                setslot("Van");
            }break;
            case "Cargo Lorry" : {
                setslot("Cargo Lorry");
            }break;
            case "Bus" : {
                setslot("Bus");
            }break;
        }
    }

    private void setslot(String vehicletype) {
        for (int i=0; i<Database.slotTable.size(); i++){
            for (int j=0; j<Database.slotTable.size(); j++){
                if (vehicletype.equals(Database.slotTable.get(i).getVehicleType()) && Database.slotTable.get(i).getStatus().equals("notUse")) {
                    lblSlot.setText(Database.slotTable.get(i).getSlotNo());
                    return;
                }
            }
        }

    }

    private void findVehicle(Object newValue) {
        int i=-1;

        for (Vehicle v: Database.vehicleTable
        ) {
            i++;
            if(v.getVehicleNo().equals(String.valueOf(newValue) )){
                setVehicle = Database.vehicleTable.get(i);
            }

        }
    }

    private void loadData() {
        ObservableList<VehicleTM> observableList = FXCollections.observableArrayList();
        for (Vehicle v: Database.vehicleTable) {
            VehicleTM tm = new VehicleTM(v.getVehicleNo());
            observableList.add(tm);
        }

        ObservableList<DriverTM> observableList2 = FXCollections.observableArrayList();
        for (Driver d: Database.driverTable) {
            DriverTM tm = new DriverTM(d.getName());
            observableList2.add(tm);
        }
        cmbSelectVehicle.setItems(observableList);
        cmbDriver.setItems(observableList2);
    }

    private void currentDateTime() {
        Timeline clock = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e->{
            LocalTime currentTime = LocalTime.now();
            LocalDate currentDate = LocalDate.now();
            lblDateAndTime.setText(currentDate.getYear()+"-"+currentDate.getMonthValue()+"-"+currentDate.getDayOfMonth()+
                    "    "+ currentTime.getHour() + ":" + currentTime.getMinute() + ":"+ currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void btnManagementLogInOnAction(ActionEvent actionEvent) throws IOException {

        URL resource= getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void btnParkVehicleOnAction(ActionEvent actionEvent) {
    }

    public void btnOnDeliveryShift(ActionEvent actionEvent) {
    }


}
