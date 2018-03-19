import com.sb.customers.CustomerEditServlet;
import com.sb.customers.CustomerServlet;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerEditTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    @InjectMocks
    private CustomerServlet customerServlet;
    @Test
    public void shouldTestCustomerServlet() throws Exception {
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
        when(request.getParameter("id")).thenReturn("42");
        new CustomerEditServlet().doGet(request, response);
        new CustomerEditServlet().doPost(request, response);

    }
}
