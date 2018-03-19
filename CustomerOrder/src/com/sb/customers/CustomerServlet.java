package com.sb.customers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(name = "CustomerServlet", urlPatterns = {"/a/b/c", "/customers"})
public class CustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        //pw.println("<h1>Customers</h1>");
        //pw.println("<h1>Customers Details</h1>");

    }

    public void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // code to process the form...
        String name = request.getParameter("name");
        String mobileNo = request.getParameter("mobileNo");
        String gmail = request.getParameter("gmail");
        String address = request.getParameter("address");
        String pin = request.getParameter("pin");
        String password = request.getParameter("password");
        Connection con=null;
        PreparedStatement ps=null;
        PrintWriter writer = response.getWriter();

        try{
            ServletContext context=getServletContext();
            Class.forName(context.getInitParameter("dname"));
            con = DriverManager.getConnection(context.getInitParameter("connectionObj"),
                    context.getInitParameter("userName"), context.getInitParameter("password"));
            ps=con.prepareStatement("INSERT INTO customers(name, mobile, addr, mail, pin, password) VALUES(?, ?, ?, ?, ?,?)");
            ps.setString(1, name);
            ps.setString(2, mobileNo);
            ps.setString(3, address);
            ps.setString(4, gmail);
            ps.setString(5, pin);
            ps.setString(6, password);
            int i=ps.executeUpdate();
            if(i>0){
                response.sendRedirect("/customerDetails.jsp");
            }
    }catch(Exception e){
            e.printStackTrace();
        }


    }
}
