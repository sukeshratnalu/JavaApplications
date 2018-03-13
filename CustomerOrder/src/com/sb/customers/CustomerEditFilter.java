package com.sb.customers;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "CustomerEditFilter")
public class CustomerEditFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String name=req.getParameter("name");
        String mobileNo=req.getParameter("mobileNo");
        String gmail=req.getParameter("gmail");
        String address=req.getParameter("address");
        String pin=req.getParameter("pin");
        if(!name.equals("") && !mobileNo.equals("") && !gmail.equals("") && !address.equals("") && !pin.equals("")){
            chain.doFilter(req, resp);//sends request to next resource
        }
        else{
            RequestDispatcher rd=req.getRequestDispatcher("/customer/edit");
            rd.include(req, resp);
            out.print("<div style='color: red;text-align:center;'>Please insert required field.</div>");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
