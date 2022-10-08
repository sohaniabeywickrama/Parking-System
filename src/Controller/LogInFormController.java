package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LogInFormController {
    public TextField txtUserName;
    public PasswordField pwdPassword;
    public AnchorPane loginContext;

    public void btnCancelOnAction(ActionEvent actionEvent) {
        CloseWindowUi(loginContext);

    }

    private void CloseWindowUi(AnchorPane loginContext) {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.close();
    }

    int attempts = 0;
    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {

        attempts++;
        if (attempts<=3){
            if (txtUserName.getText().equals("admin")&& pwdPassword.getText().equals("1234")){
                new Alert(Alert.AlertType.CONFIRMATION,"Success!").showAndWait();
                URL resource = getClass().getResource("../View/InParkingForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene = new Scene(load);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again!").show();
            }
        }else {
            txtUserName.setEditable(false);
            pwdPassword.setEditable(false);
        }



    }
}
