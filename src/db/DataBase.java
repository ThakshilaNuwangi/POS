package db;

import model.Customer;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Customer> customerTable=new ArrayList();

    static {
        customerTable.add(new Customer("C001","Nimal",25000,"Colombo"));
        customerTable.add(new Customer("C002","Wasantha",50000,"Moratuwa"));
        customerTable.add(new Customer("C003","Bandara",40000,"Panadura"));
        customerTable.add(new Customer("C004","Jayantha",30000,"Kalutara"));
        customerTable.add(new Customer("C005","Saman",85000,"Galle"));
    }
}
