package com.sb.customers.bean;

import com.sb.customers.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
        Statement statement = null;
        try{
            connection = DbConnection.getDbConnection();
            String sql = "UPDATE customers " +
                    "SET name = '"+name+"', mobile = '"+mobileNo+"', mail ='"+gmail+"', addr = '"+address+"', pin = '"+pin+"' WHERE id in ("+custId+")";
             i = statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e);
        }
        return i;
    }
}
