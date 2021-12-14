package view.tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private String id;
    private String name;
    private double salary;
    private String address;
    private Button btn;

    public CustomerTM() {
    }

    public CustomerTM(String id, String name, double salary, String address, Button btn) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.btn = btn;

        this.btn.setStyle("-fx-background-color: #F63A05;"+
                "-fx-text-fill: white;");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", btn=" + btn +
                '}';
    }
}
