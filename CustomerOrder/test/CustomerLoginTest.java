import com.sb.customers.service.CustomerLoginServlet;
import com.sb.customers.bean.LoginBean;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerLoginTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    ServletContext context = mock(ServletContext.class);
    CustomerLoginServlet customerLoginServlet = new CustomerLoginServlet(){
        public ServletContext getServletContext() {
            return context; // return the mock
        }
    };
    LoginBean bean= mock(LoginBean.class);
    /*@InjectMocks
    private CustomerLoginServlet customerLoginServlet;*/
    @Test
    public void shouldTestLogin() throws Exception {
        when(request.getRequestDispatcher("login.jsp")).thenReturn(new RequestDispatcher() {
            @Override
            public void forward(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

            }

            @Override
            public void include(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

            }
        });
        when(context.getInitParameter("dname")).thenReturn("org.postgresql.Driver");
        when(context.getInitParameter("connectionObj")).thenReturn("jdbc:postgresql://localhost:5432/customer_orders");
        when(context.getInitParameter("userName")).thenReturn("customer");
        when(context.getInitParameter("password")).thenReturn("customer");
        //customerLoginServlet.doPost(request, response);
        when(request.getParameter("name")).thenReturn("Sukesh kumar");
        when(request.getParameter("password")).thenReturn("skr");
        bean.setName("Sukesh kumar");
        bean.setPassword("skr");
        when(bean.validate()).thenReturn(true);
        customerLoginServlet.doPost(request, response);


    }
}
