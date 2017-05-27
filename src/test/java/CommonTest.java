import com.staryn.blog.util.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-25 12:51:00
 */
public class CommonTest {

    @Test
    public void testMain() throws Exception {
        Date date = new Date();
        double seconds = Math.floor((date.getTime() - DateUtil.parse("2015-03-03 00:00:00").getTime()) / 1000);
        System.out.println(date.getTime());
        System.out.println(DateUtil.parse("2015-03-03 00:00:00").getTime());
        System.out.println((long)seconds);
        System.out.println(seconds / (3600 * 24));
    }
}
