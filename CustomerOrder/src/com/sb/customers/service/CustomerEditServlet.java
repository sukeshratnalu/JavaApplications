package com.sb.customers.service;

import com.sb.customers.bean.EditCustomerBean;
import com.sb.customers.util.DbConnection;

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
    String custId = null;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code to process the form...
        String name = request.getParameter("name");
        String mobileNo = request.getParameter("mobileNo");
        String gmail = request.getParameter("gmail");
        String address = request.getParameter("address");
        String pin = request.getParameter("pin");
        EditCustomerBean editCustomerBean = new EditCustomerBean();
        editCustomerBean.setName(name);
        editCustomerBean.setMobileNo(mobileNo);
        editCustomerBean.setGmail(gmail);
        editCustomerBean.setAddress(address);
        editCustomerBean.setPin(pin);
        int i = editCustomerBean.editCustomer(custId);
            if(i>0){
                response.sendRedirect("/customerDetails.jsp");
            }else {
                System.out.println("error");
            }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con=null;
        PreparedStatement ps=null;
        PrintWriter writer = response.getWriter();
        String id = "id";
        custId = request.getParameter(id);
        try{

            con = DbConnection.getDbConnection();
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
