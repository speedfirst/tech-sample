import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

class SimpleBean {
    public int num;

    @JsonWriteNullProperties
    public String str;
}

class SimpleNamedBean {
    @JsonProperty("my-num")
    public int num;

    @JsonProperty("my-str")
    public String str;
}

public class JacksonTest {

    private static ObjectMapper objectMapper;

    @BeforeClass
    public static void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testWriteJson() throws IOException {
        SimpleBean sb = new SimpleBean();
        sb.num = 1;
        sb.str = "abc";
        String res = objectMapper.writeValueAsString(sb);
        assertEquals("{\"num\":1,\"str\":\"abc\"}", res);
    }

    @Test
    public void testWriteNamedJson() throws IOException {
        SimpleNamedBean sb = new SimpleNamedBean();
        sb.num = 1;
        sb.str = "abc";
        String res = objectMapper.writeValueAsString(sb);
        assertEquals("{\"my-num\":1,\"my-str\":\"abc\"}", res);
    }
}
