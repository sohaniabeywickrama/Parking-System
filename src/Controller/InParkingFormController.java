package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class InParkingFormController {
    public AnchorPane InParkingContext;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public ComboBox cmbInParking;

    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource= getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {

    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {

            URL resource= getClass().getResource("../view/AddDriverForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

    }
}
