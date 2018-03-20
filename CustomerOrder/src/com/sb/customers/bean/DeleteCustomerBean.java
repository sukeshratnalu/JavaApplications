package com.sb.customers.bean;

import com.sb.customers.util.DbConnection;
import com.sb.customers.util.QueryConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
        PreparedStatement preparedStatement = null;
        String query = QueryConstant.CUSTOMER_DELETE_QUERY;
        try{
            connection = DbConnection.getDbConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,Integer.parseInt(id));
            i=preparedStatement.executeUpdate();
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
