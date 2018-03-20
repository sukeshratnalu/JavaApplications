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
        loginBean.validate("org.postgresql.Driver","jdbc:postgresql://localhost:5432/customer_orders",
                "customer","customer");
        loginBean.validate("org.postgresql.Driver","jdbc:postgresql://localhost:5432/customer_orders",
                "customer","custome1");
    }
}
