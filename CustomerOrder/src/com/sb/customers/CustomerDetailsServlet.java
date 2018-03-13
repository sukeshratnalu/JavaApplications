package com.sb.customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "CustomerDetailsServlet")
public class CustomerDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection con=null;
        PreparedStatement ps=null;
        PrintWriter writer = response.getWriter();
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/customer_orders", "customer", "customer");
            String query = "SELECT id, name, mobile, mail, addr, pin  FROM   customers";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            String htmlRespone = "<style>\n" +
                    "table {\n" +
                    "    font-family: arial, sans-serif;\n" +
                    "    border-collapse: collapse;\n" +
                    "    width: 100%;\n" +
                    "}\n" +
                    "\n" +
                    "td, th {\n" +
                    "    border: 1px solid #dddddd;\n" +
                    "    text-align: left;\n" +
                    "    padding: 8px;\n" +
                    "}\n" +
                    "\n" +
                    "tr:nth-child(even) {\n" +
                    "    background-color: #dddddd;\n" +
                    "}\n" +
                    "</style><html>";
            htmlRespone += "<div><h1>Customer Details</h1>&nbsp&nbsp&nbsp&nbsp&nbsp<a href='/addCustomer.jsp'>" +
                    "Add New Customer</a></div></br></br><table><tr><th>Name</th><th>Mobile No</th><th>Gmail</th>" +
                    "<th>Address</th><th>Pin</th><th>Action</th></tr>";
            while (rs.next())
            {
                String custName = rs.getString("name");
                String custMobileNo = rs.getString("mobile");
                String custGmail = rs.getString("mail");
                String custAddress = rs.getString("addr");
                String custPin = rs.getString("pin");
                String custId = rs.getString("id");
                htmlRespone += "<tr><td>"+custName+"</td><td>"+custMobileNo+"</td><td>"+custGmail+"</td><td>"+custAddress+
                        "</td><td>"+custPin+"</td><td><a href='/customer/edit?id="+custId+"'>Edit</a>&nbsp&nbsp<a href='/customer/delete?id="+custId+"'> Delete </td></tr>";
            }
            htmlRespone += "</table></html>";
            writer.println(htmlRespone);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
