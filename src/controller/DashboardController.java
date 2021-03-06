package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    public AnchorPane dashboardContext;

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm");
    }
    
    public void btnItemOnAction(ActionEvent actionEvent) {
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnOrderDetailsOnAction(ActionEvent actionEvent) {
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) dashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
