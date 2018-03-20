import com.sb.customers.service.CustomerDetailsServlet;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.Writer;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerDetailsServletTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    ServletContext context = mock(ServletContext.class);
    CustomerDetailsServlet customerDetailsServlet = new CustomerDetailsServlet(){
        public ServletContext getServletContext() {
            return context; // return the mock
        }
    };
    @Test
    public void shouldTestCustomerDetailsServlet() throws Exception{
        /*CustomerDetailsServlet customerDetailsServlet = new CustomerDetailsServlet();*/
        Writer out = new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {

            }

            @Override
            public void flush() throws IOException {

            }

            @Override
            public void close() throws IOException {

            }
        };
        when(response.getWriter()).thenReturn(new PrintWriter(out));
        when(context.getInitParameter("dname")).thenReturn("gdhfgsd");
        when(context.getInitParameter("connectionObj")).thenReturn("gdhfgsd");
        when(context.getInitParameter("userName")).thenReturn("gdhfgsd");
        when(context.getInitParameter("password")).thenReturn("gdhfgsd");
        customerDetailsServlet.doPost(request, response);
        customerDetailsServlet.doGet(request, response);
        when(context.getInitParameter("dname")).thenReturn("org.postgresql.Driver");
        when(context.getInitParameter("connectionObj")).thenReturn("jdbc:postgresql://localhost:5432/customer_orders");
        when(context.getInitParameter("userName")).thenReturn("customer");
        when(context.getInitParameter("password")).thenReturn("customer");
        customerDetailsServlet.doGet(request, response);
    }

}
