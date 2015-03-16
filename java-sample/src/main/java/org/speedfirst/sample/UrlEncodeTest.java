package org.speedfirst.sample;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Test for url encode
 */
public class UrlEncodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String res = URLEncoder.encode("http://www.amazon.com", "utf-8");
        System.out.println(res);

        res = URLEncoder.encode("http://www.amazon.com", "ISO-8859-1");
        System.out.println(res);
    }
}
