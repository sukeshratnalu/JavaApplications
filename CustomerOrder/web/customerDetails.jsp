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
<%@ page import="com.sb.customers.bean.ListCustomersBean" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ include file="index.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    Map customerData = (Map) request.getAttribute("cusomerList");
    Iterator iterator = customerData.entrySet().iterator();
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
    while (iterator.hasNext()) {
        Map.Entry pair = (Map.Entry)iterator.next();
        ArrayList customerList = (ArrayList) pair.getValue();
        Iterator listIterator = customerList.iterator();
        htmlRespone +="<tr>";
        while (listIterator.hasNext()) {
            htmlRespone += "<td>"+listIterator.next()+"</td>";
        }
        htmlRespone += "<td><a href='/customer/edit?id="+pair.getKey()+"'>Edit</a>&nbsp&nbsp<a href='/customer/delete?id="+pair.getKey()+"'> Delete </td></tr>";

    }
    htmlRespone += "</table></html>";
    out.println(htmlRespone);
%>
</body>
</html>
