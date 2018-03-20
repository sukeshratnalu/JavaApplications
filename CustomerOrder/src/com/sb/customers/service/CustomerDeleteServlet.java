package com.sb.customers.service;

import com.sb.customers.bean.DeleteCustomerBean;
import com.sb.customers.util.DbConnection;

import javax.servlet.ServletContext;
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = "id";
        Boolean isDeleted=false;
        custId = request.getParameter(id);
        Connection conn = null;
        Statement stmt = null;
        DeleteCustomerBean deleteCustomerBean = new DeleteCustomerBean();
        deleteCustomerBean.setId(custId);
        isDeleted = deleteCustomerBean.deleteCustomer();
        if(isDeleted){
            response.sendRedirect("/customerDetails.jsp");
        }else{

        }

    }
}
