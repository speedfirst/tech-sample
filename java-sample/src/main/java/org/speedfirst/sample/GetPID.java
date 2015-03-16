package org.speedfirst.sample;


import java.lang.management.ManagementFactory;

public class GetPID {
    public static void main(String[] args) {
        String token = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(token);
    }
}
