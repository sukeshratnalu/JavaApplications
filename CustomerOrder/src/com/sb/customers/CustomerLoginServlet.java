package com.sb.customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con=null;
        PreparedStatement ps=null;
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/customer_orders", "customer", "customer");
            String query = "SELECT id, name, mobile, mail, addr, pin  FROM   customers WHERE name='"+name+"' AND password ='"+password+"'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            int count = 0;
            while (rs.next())
            {
                count++;
            }
            if(count>0){
                response.sendRedirect("/customerDetails.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
