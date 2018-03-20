package com.sb.customers.bean;

import com.sb.customers.util.DbConnection;

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
    public boolean validate(String dbName, String connectionObj, String dbUserName, String dbPassword){
        Connection con=null;
        PreparedStatement ps=null;
        int count = 0;
        try{
            con = DbConnection.getDbConnection();
            String query = "SELECT id, name, mobile, mail, addr, pin  FROM   customers WHERE name='"+name+"' AND password ='"+password+"'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
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
