package com.sb.customers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/a/b/c", "/customers"})
public class CustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>Customers</h1>");
        pw.println("<h1>Customers Details</h1>");

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // code to process the form...
        String name = request.getParameter("name");
        String mobileNo = request.getParameter("mobileNo");
        String gmail = request.getParameter("gmail");
        String address = request.getParameter("address");
        String pin = request.getParameter("pin");

        PrintWriter writer = response.getWriter();
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
        htmlRespone += "<table><tr><th>Name</th><th>Mobile No</th><th>Gmail</th><th>Address</th><th>Pin</th></th>";
        htmlRespone += "<tr><td>"+name+"</td><td>"+mobileNo+"</td><td>"+gmail+"</td><td>"+address+"</td><td>"+pin+"</td></tr>";
        htmlRespone += "</table></html>";

        writer.println(htmlRespone);

    }
}
