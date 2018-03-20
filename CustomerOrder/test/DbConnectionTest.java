import com.sb.customers.util.DbConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.io.FileInputStream;

public class DbConnectionTest {
    //@RunWith(PowerMockRunner.class)
    @Test
    public void shouldTestDbConnection(){
       /* final FileInputStream fileInputStreamMock = PowerMockito.mock(FileInputStream.class);
        PowerMockito.whenNew(FileInputStream.class).withArguments(Matchers.anyString())
                .thenReturn(fileInputStreamMock);*/
        DbConnection.getDbConnection();
    }
}
