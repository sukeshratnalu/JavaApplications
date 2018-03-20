package com.sb.customers.bean;

import com.sb.customers.util.DbConnection;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteCustomerBean {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean deleteCustomer(){
        int i = 0;
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DbConnection.getDbConnection();
            statement = connection.createStatement();
            String sql = "DELETE FROM customers WHERE id = "+this.id;
            i=statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e);
        }
        if(i>0){
            return true;
        }else{
            return false;
        }

    }
}
