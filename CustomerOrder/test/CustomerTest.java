
import com.sb.customers.CustomerServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {
    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    @InjectMocks
    private CustomerServlet customerServlet;
    @Test
    public void shouldTestCustomerServlet() throws Exception {
        //PrintWriter pw = Mockito.mock(PrintWriter.class);
        customerServlet.doGet(request, response);
        customerServlet.doPost(request, response);

    }
}
