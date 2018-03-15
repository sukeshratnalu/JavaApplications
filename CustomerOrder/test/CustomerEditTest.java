import com.sb.customers.CustomerEditServlet;
import com.sb.customers.CustomerServlet;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

public class CustomerEditTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    @InjectMocks
    private CustomerServlet customerServlet;
    @Test
    public void shouldTestCustomerServlet() throws Exception {
        //PrintWriter pw = Mockito.mock(PrintWriter.class);
        new CustomerEditServlet().doGet(request, response);
        new CustomerEditServlet().doPost(request, response);

    }
}
