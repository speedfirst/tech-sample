package org.speedfirst.sample;

import java.util.ArrayList;

/**
 * Created by jiankuan on 9/10/14.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(5);
        System.out.println(arrayList.size());
        arrayList.add("Hahah");
        System.out.println(arrayList.size());

    }
}
