import com.sb.customers.service.CustomerDeleteServlet;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerDeleteTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    ServletContext context = mock(ServletContext.class);
    CustomerDeleteServlet customerDeleteServlet = new CustomerDeleteServlet(){
        public ServletContext getServletContext() {
            return context; // return the mock
        }
    };
    @Test
    public void shouldTestCustomerDelete() throws Exception{
        when(context.getInitParameter("dname")).thenReturn("org.postgresql.Driver");
        when(context.getInitParameter("connectionObj")).thenReturn("jdbc:postgresql://localhost:5432/customer_orders");
        when(context.getInitParameter("userName")).thenReturn("customer");
        when(context.getInitParameter("password")).thenReturn("customer");
        customerDeleteServlet.doGet(request, response);
        when(context.getInitParameter("dname")).thenReturn("gdhfgsd");
        when(context.getInitParameter("connectionObj")).thenReturn("gdhfgsd");
        when(context.getInitParameter("userName")).thenReturn("gdhfgsd");
        when(context.getInitParameter("password")).thenReturn("gdhfgsd");
        customerDeleteServlet.doGet(request, response);
    }
}
