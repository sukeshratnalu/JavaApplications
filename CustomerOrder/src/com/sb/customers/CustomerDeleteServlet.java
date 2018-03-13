package com.sb.customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet(name = "CustomerDeleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
    String custId = "";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = "id";
        custId = request.getParameter(id);
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/customer_orders", "customer", "customer");
            stmt = conn.createStatement();
            String sql = "DELETE FROM customers " +
                    "WHERE id = "+custId;
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql);
            response.sendRedirect("/customerDetails.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
