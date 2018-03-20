import com.sb.customers.bean.LoginBean;
import org.junit.Test;

public class LoginBeanTest {
    LoginBean loginBean = new LoginBean();
    @Test
    public void shouldTestLoginBean(){
        loginBean.setName("Sukesh kumar");
        loginBean.getName();
        loginBean.setPassword("skr");
        loginBean.getPassword();
        loginBean.validate();
        loginBean.validate();
    }
}
