package org.speedfirst.test;


import java.io.IOException;
import java.util.*;

/**
 * Created by jiankuan on 10/16/14.
 */

//class HelloA {
//    public HelloA() {
//        System.out.println("HelloA");
//    }
//
//    { System.out.println("Class A"); }
//
//    static { System.out.println("Static A"); }
//}
//
//public class HelloB extends HelloA {
//    public HelloB() {
//        System.out.println("HelloB");
//    }
//
//    { System.out.println("Class B"); }
//
//        static { System.out.println("Static B"); }
//
//    public static void main(String[] args) {
//        new HelloB();
//    }
//}

public class RemoveDuplicate {
    public int[] removeDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        int target = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (set.contains(num)) {
                continue;
            } else {
                arr[target] = num;
                set.add(num);
                target++;
            }
        }

        return Arrays.copyOf(arr, target);
    }

    public List<Integer> top100(List<Integer> input) {

        TreeSet<Integer> set = new TreeSet<Integer>();
        int i = 0;
        for (; i < 10; i++) {
            set.add(input.get(i));
        }

        for (; i < input.size(); i++) {
            int num = input.get(i);
            if (num < set.first()) {
                continue;
            } else {
                set.pollFirst();
                set.add(num);
            }
        }

        return new ArrayList<Integer>(set);
    }

    public  void main2(String[] args) throws IOException, InterruptedException {
//        List<Integer> arr = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            arr.add(i);
//        }
//
//        List<Integer> res = new RemoveDuplicate().top100(arr);
//        for (int num: res) {
//            System.out.println(num);
//        }

//        short v1 = 18;
//
//        Long v2 = new Long("18");
//
//        Long v3 = new Long(18);
//
//        Short v4 = new Short(v1);
//
//        System.out.println(v1 == v2);
//        System.out.println(v2 == v3);
//        System.out.println(v3.equals(v1));
//        System.out.println(v3.equals(v4));
//        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
//        System.out.println(zdt);
//        ZonedDateTime zdt2 = zdt.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
//        System.out.println(zdt2);
//        ZonedDateTime zdt3 = zdt.withZoneSameLocal(ZoneId.of("Asia/Shanghai"));
//        System.out.println(zdt3);
//        System.out.println(ZoneId.systemDefault());
        for (int i = 1; i <= 100; i++) {
            System.out.print(String.format("This is going to be changed %2s\r", i));
            Thread.sleep(500);
        }


    }

    public static void main(String[] a){
        System.out.println("\\]".equals("\\]"));
        System.out.println("\\[".equals("\\["));
        long b = 1L;
    }
}

//public class MySample {
//    public static void main(String [] args) {
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//
//        TreeNode n4 = new TreeNode(4);
//
//        TreeNode n5 = new TreeNode(5);
//
//        TreeNode n7 = new TreeNode(7);
//
//        TreeNode n12 = new TreeNode(12);
//
//        n5.left = n4;
//        n5.right = n2;
//        n4.left = n3;
//        n2.left = n7;
//        n2.right = n1;
//        n1.right = n12;
//
//        System.out.println(new MySample().xSum(n5));
//
//
//    }
//
//    public int xSum(TreeNode root)
//    {
//        if (root == null)
//            return 0;
//        return root.getValue() + xSum(root.getRight()) - xSum(root.getLeft());
//    }
//
//}
//
//class TreeNode {
//
//    public TreeNode(int value) {
//        this.value = value;
//    }
//    int value;
//
//    public int getValue() {
//        return value;
//    }
//
//    TreeNode left;
//
//    TreeNode right;
//
//    public TreeNode getRight() {
//        return right;
//    }
//
//    public TreeNode getLeft() {
//        return left;
//    }
//}
