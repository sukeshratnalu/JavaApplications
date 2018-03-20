
import com.sb.customers.service.CustomerServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    ServletContext servletContext = mock(ServletContext.class);
    CustomerServlet customerServlet = new CustomerServlet(){
        public ServletContext getServletContext() {
            return servletContext; // return the mock
        }
    };
    @Test
    public void shouldTestCustomerServlet() throws Exception {
        //PrintWriter pw = Mockito.mock(PrintWriter.class);
        /**/
        when(servletContext.getInitParameter("dname")).thenReturn("org.postgresql.Driver");
        when(servletContext.getInitParameter("connectionObj")).thenReturn("jdbc:postgresql://localhost:5432/customer_orders");
        when(servletContext.getInitParameter("userName")).thenReturn("customer");
        when(servletContext.getInitParameter("password")).thenReturn("custome");
        customerServlet.doGet(request, response);
        customerServlet.doPost(request, response);
    }
    @Test
    public void shouldTestCustomerServletCatch()throws Exception{
        when(servletContext.getInitParameter("dname")).thenReturn("org.postgresql.Driver");
        when(servletContext.getInitParameter("connectionObj")).thenReturn("jdbc:postgresql://localhost:5432/customer_orders");
        when(servletContext.getInitParameter("userName")).thenReturn("customer");
        when(servletContext.getInitParameter("password")).thenReturn("customer");
        customerServlet.doPost(request, response);
    }
}
