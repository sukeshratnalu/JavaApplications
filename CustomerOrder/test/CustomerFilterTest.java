import com.sb.customers.service.CustomerFilter;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerFilterTest {
    @Mock
    ServletRequest request = mock(ServletRequest.class);
    ServletResponse response = mock(ServletResponse.class);
    FilterConfig filterConfig = mock(FilterConfig.class);
    FilterChain chain = mock(FilterChain.class);
    @Test
    public void shouldTestCustomerFilter()throws Exception{
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
        when(request.getRequestDispatcher("addCustomer.jsp")).thenReturn(new RequestDispatcher() {
            @Override
            public void forward(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

            }

            @Override
            public void include(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

            }
        });
        when(request.getParameter("name")).thenReturn("sss");
        when(request.getParameter("mobileNo")).thenReturn("231423");
        when(request.getParameter("gmail")).thenReturn("sss@jdf.as");
        when(request.getParameter("address")).thenReturn("fdhg");
        when(request.getParameter("pin")).thenReturn("5435634");
        CustomerFilter customerFilter = new CustomerFilter();
        customerFilter.init(filterConfig);
        customerFilter.doFilter(request,response,chain);
        when(request.getParameter("name")).thenReturn("");
        when(request.getParameter("mobileNo")).thenReturn("");
        when(request.getParameter("gmail")).thenReturn("");
        when(request.getParameter("address")).thenReturn("");
        when(request.getParameter("pin")).thenReturn("");
        customerFilter.doFilter(request,response,chain);
        customerFilter.destroy();
    }
}
