package com.sb.customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "CustomerEditServlet")
public class CustomerEditServlet extends HttpServlet {
    String custId = "";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code to process the form...
        String name = request.getParameter("name");
        String mobileNo = request.getParameter("mobileNo");
        String gmail = request.getParameter("gmail");
        String address = request.getParameter("address");
        String pin = request.getParameter("pin");
        Connection con=null;
        PreparedStatement ps=null;
        Statement st = null;
        PrintWriter writer = response.getWriter();

        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/customer_orders", "customer", "customer");
            st = con.createStatement();
            String sql = "UPDATE customers " +
                    "SET name = '"+name+"', mobile = '"+mobileNo+"', mail ='"+gmail+"', addr = '"+address+"', pin = '"+pin+"' WHERE id in ("+custId+")";
            int i = st.executeUpdate(sql);
            if(i>0){
                response.sendRedirect("/customerDetails.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con=null;
        PreparedStatement ps=null;
        PrintWriter writer = response.getWriter();
        String id = "id";
        custId = request.getParameter(id);
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/customer_orders", "customer", "customer");
            String query = "SELECT id, name, mobile, mail, addr, pin  FROM   customers WHERE id="+custId;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            String htmlRespone ="";
            while (rs.next())
            {

                String custName = rs.getString("name");
                String custMobileNo = rs.getString("mobile");
                String custGmail = rs.getString("mail");
                String custAddress = rs.getString("addr");
                String custPin = rs.getString("pin");
                htmlRespone = "<html><style>\n" +
                        "    form{\n" +
                        "        text-align: center;\n" +
                        "    }\n" +
                        "</style><h1>Edit Customer Details</h1><form name='customerForm' method='post' action='/customer/edit'> " +
                        "<b>Name:</b> <br/><input type='text' name='name' value='"+custName+"'><br/>" +
                        "<b>Mobile No:</b> <br/><input type='text' name='mobileNo' value='"+custMobileNo+"'><br/>" +
                        "<b>Gmail:</b> <br/><input type='text' name='gmail' value='"+custGmail+"'><br/>" +
                        "<b>Address:</b> <br/><input type='text' name='address' value='"+custAddress+"'><br/>" +
                        "<b>PIN:</b> <br/><input type='text' name='pin' value='"+custPin+"'><br/><br/><br/>" +
                        "<input type='submit' value='Submit' /></form></html>";


            }
            writer.println(htmlRespone);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
