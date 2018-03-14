<%--
  Created by IntelliJ IDEA.
  User: semanticbits
  Date: 13/3/18
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="index.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Connection con = null;
    Statement statement = null;
    ArrayList customerList = new ArrayList();
    try {
        Class.forName(application.getInitParameter("dname"));
    } catch (ClassNotFoundException e) {
        System.out.println("Where is your PostgreSQL JDBC Driver? "
                + "Include in your library path!");
        e.printStackTrace();
        return;
    }
    try{
        con = DriverManager.getConnection(application.getInitParameter("connectionObj"), application.getInitParameter("userName"), application.getInitParameter("password"));
        String query = "SELECT id, name, mobile, mail, addr, pin  FROM   customers";
        statement = con.createStatement();
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
        out.println(htmlRespone);
    }catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>
