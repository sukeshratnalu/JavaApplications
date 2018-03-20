package com.sb.customers.bean;

import com.sb.customers.util.DbConnection;
import com.sb.customers.util.QueryConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditCustomerBean {
    String name, mobileNo, gmail, address, pin;

    public String getName() {
        return name;
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

    public int editCustomer(String custId){
        int i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = QueryConstant.CUSTOMER_UPDATE_QUERY;
        try{
            connection = DbConnection.getDbConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mobileNo);
            preparedStatement.setString(3, gmail);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, pin);
            preparedStatement.setInt(6, Integer.parseInt(custId));
            i=preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("edit"+e);
        }
        return i;
    }
}
