package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;
import view.tm.CustomerTM;

import java.io.IOException;

public class CustomerFormController {
    public AnchorPane customerFormContext;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtSalary;
    public TableView<CustomerTM> tblCustomers;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colSalary;
    public TableColumn colAddress;
    public TableColumn colOption;
    public JFXButton btnManipulate;
    public TextField txtSearch;

    private String searchText="";

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllCustomers(searchText);

        tblCustomers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null){
                setData(newValue);
            }
        });
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText=newValue;
            loadAllCustomers(searchText);
        });
    }

    private void setData(CustomerTM newValue) {
        btnManipulate.setText("Update");
        txtId.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtAddress.setText(newValue.getAddress());
        txtSalary.setText(String.valueOf(newValue.getSalary()));
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) customerFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Dashboard.fxml"))));
    }

    public void btnManipulateOnAction(ActionEvent actionEvent) {
        if (btnManipulate.getText().equals("Save")){
            //Save Customer
            if (DataBase.customerTable.add(new Customer(
                    txtId.getText(),
                    txtName.getText(),
                    Double.parseDouble(txtSalary.getText()),
                    txtAddress.getText()
            ))) {
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
            }
        }else{
            for (Customer customer:DataBase.customerTable
                 ) {
                if (txtId.getText().equals(customer.getId())){
                    customer.setName(txtName.getText());
                    customer.setAddress(txtAddress.getText());
                    customer.setSalary(Double.parseDouble(txtSalary.getText()));
                }
            }
            new Alert(Alert.AlertType.CONFIRMATION,"Updated!").show();
        }
        loadAllCustomers(searchText);
    }

    ObservableList<CustomerTM> customerList= FXCollections.observableArrayList();
    private void loadAllCustomers(String searchText){
        customerList.clear();
        for (Customer c:DataBase.customerTable
             ) {
            if (c.getId().contains(searchText)||
                c.getName().contains(searchText)||
                c.getAddress().contains(searchText)
            ){
                Button btn=new Button("Delete");
                CustomerTM tm=new CustomerTM(
                        c.getId(),c.getName(),c.getSalary(),c.getAddress(),btn
                );
                customerList.add(tm);
                btn.setOnAction((e)->{
                    DataBase.customerTable.remove(c);
                    new Alert(Alert.AlertType.CONFIRMATION,"Deleted!").show();
                    loadAllCustomers(searchText);
                });
            }
        }
        tblCustomers.setItems(customerList);
    }

    public void newCustomerOnAction(ActionEvent actionEvent) {
        btnManipulate.setText("Save");
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();
        txtId.requestFocus();
    }
}