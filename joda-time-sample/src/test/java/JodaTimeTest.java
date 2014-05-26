import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JodaTimeTest {

    @Test
    public void testNow() {
        DateTime dateTime = DateTime.now();
        System.out.println(dateTime);
    }

    @Test
    public void testFormat() {
        DateTime dt = new DateTime(2014, 5, 14, 3, 28, 45, 20);
        assertEquals("20140514 03:28:45 020", dt.toString("YYYYMMdd HH:mm:ss SSS"));
    }
}
