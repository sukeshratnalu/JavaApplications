package com.sb.customers.bean;

import com.sb.customers.util.DbConnection;
import com.sb.customers.util.QueryConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddCustomerBean {
    String name, password, mobileNo, gmail, address, pin;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getGmail() {
        return gmail;
    }

    public String getAddress() {
        return address;
    }

    public String getPin() {
        return pin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int addCustomer(){
        int i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
           connection = DbConnection.getDbConnection();
            preparedStatement=connection.prepareStatement(QueryConstant.CUSTOMER_INSERT_QUERY);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mobileNo);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, gmail);
            preparedStatement.setString(5, pin);
            preparedStatement.setString(6, password);
            i=preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return i;
    }
}
