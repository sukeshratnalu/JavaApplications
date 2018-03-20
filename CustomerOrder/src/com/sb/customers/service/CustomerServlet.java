package com.sb.customers.service;

import com.sb.customers.bean.AddCustomerBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "CustomerServlet", urlPatterns = {"/a/b/c", "/customers"})
public class CustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

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
        AddCustomerBean addCustomerBean = new AddCustomerBean();
        addCustomerBean.setName(name);
        addCustomerBean.setPassword(password);
        addCustomerBean.setMobileNo(mobileNo);
        addCustomerBean.setGmail(gmail);
        addCustomerBean.setAddress(address);
        addCustomerBean.setPin(pin);
        int i=addCustomerBean.addCustomer();
        if(i>0){
            response.sendRedirect("/customerDetails.jsp");
        }else{
            System.out.println("error");
        }
    }
}
