import com.sb.customers.CustomerLoginServlet;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

public class CustomerLoginTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    /*@InjectMocks
    private CustomerLoginServlet customerLoginServlet;*/
    @Test
    public void shouldTestLogin() throws Exception {
        new CustomerLoginServlet().doPost(request, response);

    }
}
