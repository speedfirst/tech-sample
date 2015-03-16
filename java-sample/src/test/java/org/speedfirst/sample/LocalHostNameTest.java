package org.speedfirst.sample;

import java.net.UnknownHostException;

public class LocalHostNameTest {
    public static void main(String[] args) throws UnknownHostException {
        String localhostname = java.net.InetAddress.getLocalHost().getHostName();
        System.out.println(localhostname);
    }
}
