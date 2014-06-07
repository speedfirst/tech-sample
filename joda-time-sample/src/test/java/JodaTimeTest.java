import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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

    @Test
    public void ts2Time() {
        // the 6 bytes ts can represent 10889 year, so 6 bytes are good enough to represent the time
        DateTime dt = new DateTime(0x00FFFFFFFFFFFFl, DateTimeZone.UTC);
        assertEquals("10889-08-02T05:31:50.655Z", dt.toString());
    }
}
