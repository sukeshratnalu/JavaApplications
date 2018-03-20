package com.sb.customers.bean;

import com.sb.customers.util.DbConnection;
import com.sb.customers.util.QueryConstant;

import java.sql.*;

public class LoginBean {
    private String name,password;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean validate(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String query = QueryConstant.CUSTOMER_LOGIN_SELECT_QUERY;
        int count = 0;
        try{
            connection = DbConnection.getDbConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                count++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        if(count>0){
            return true;
        }else {
            return false;
        }
    }
}
