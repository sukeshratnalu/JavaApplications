package com.sb.customers.service;

import com.sb.customers.bean.ListCustomersBean;
import com.sb.customers.util.DbConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "CustomerDetailsServlet")
public class CustomerDetailsServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ListCustomersBean listCustomersBean = new ListCustomersBean();
        Map customerData = listCustomersBean.listCustomers();
        HttpSession session = request.getSession(true);
        if(!customerData.isEmpty()){
           // session.setAttribute("customerList",customerData);
           // response.sendRedirect("/customerDetails.jsp");
            request.setAttribute("cusomerList",customerData);
            RequestDispatcher rd=request.getRequestDispatcher("/customerDetails.jsp");
            rd.forward(request, response);
        }else{
            System.out.println("no data found");
        }
    }
}
