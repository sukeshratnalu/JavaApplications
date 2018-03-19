import com.sb.customers.CustomerDeleteServlet;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

public class CustomerDeleteTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    @Test
    public void shouldTestCustomerDelete() throws Exception{
        CustomerDeleteServlet customerDeleteServlet = new CustomerDeleteServlet();
        customerDeleteServlet.doGet(request, response);
    }
}
