package com.sb.customers.bean;

import com.sb.customers.util.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListCustomersBean {
    //ArrayList eachCustomerList = new ArrayList();
    ArrayList customerList = new ArrayList();


    public ArrayList listCustomers(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DbConnection.getDbConnection();
            String query = "SELECT id, name, mobile, mail, addr, pin  FROM   customers";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                ArrayList eachCustomerList = new ArrayList();
                eachCustomerList.add(rs.getString("name"));
                eachCustomerList.add(rs.getString("mobile"));
                eachCustomerList.add(rs.getString("mail"));
                eachCustomerList.add(rs.getString("addr"));
                eachCustomerList.add(rs.getString("pin"));
                eachCustomerList.add(rs.getString("id"));
                customerList.add(eachCustomerList);

            }

        }catch (Exception e){
            System.out.println(e);
        }
        return customerList;
    }
}
