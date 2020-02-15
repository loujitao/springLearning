import com.steve.tx.TxConfig;
import com.steve.tx.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: TODO
 * @Author: SteveTao
 * @Date: 2020/2/1515:19
 **/
public class TXTest {

    @Autowired
    private UserService userService;
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insert();

    }
}
