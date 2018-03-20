package com.sb.customers.service;

import com.sb.customers.bean.LoginBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con=null;
        PreparedStatement ps=null;
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        LoginBean bean=new LoginBean();
        bean.setName(name);
        bean.setPassword(password);
        request.setAttribute("bean",bean);
        //getting connection data
        ServletContext servletContext = getServletContext();
        String dbName = servletContext.getInitParameter("dname");
        String connectionObj = servletContext.getInitParameter("connectionObj");
        String user = servletContext.getInitParameter("userName");
        String dbPassword = servletContext.getInitParameter("password");
        boolean status=bean.validate(dbName, connectionObj, user, dbPassword);
        if(status){
            RequestDispatcher rd=request.getRequestDispatcher("customerDetails.jsp");
            rd.forward(request, response);
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }

    }

}
