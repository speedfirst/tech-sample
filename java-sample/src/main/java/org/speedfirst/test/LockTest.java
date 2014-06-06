package org.speedfirst.test;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Sample code for Reentrant Lock & Condition
 */
class LockTest {
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final LinkedList<Integer> queue = new LinkedList<>();

    class PutThread extends Thread {

        public PutThread(int num) {
            setName("Put" + num);
        }


        final int MAX_SIZE = 10;
        final Random r = new Random();

        @Override
        public void run() {
            lock.lock();
            try {
                while (queue.size() == MAX_SIZE) {
                    System.out.println(Thread.currentThread().getName() + " is going to wait");
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " is awakened");
                }
                int val = r.nextInt();
                queue.offer(val);
                System.out.println("Enqueue " + val);
                notEmpty.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    class TakeThread extends Thread {

        public TakeThread(int num) {
            setName("Take" + num);
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " is going to wait");
                    notEmpty.await();
                    System.out.println(Thread.currentThread().getName() + " is waken up");
                }
                int val = queue.poll();
                System.out.println("Unqueue " + val);

                if (getName().equals("Take1")) {
                    Thread.sleep(5000);
                }

                notFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void doTest() {
        TakeThread tt1 = new TakeThread(1);
        TakeThread tt2 = new TakeThread(2);
        TakeThread tt3 = new TakeThread(3);
        tt1.start();
        tt2.start();
        tt3.start();

        PutThread pt1 = new PutThread(1);
        pt1.start();
    }

    public static void main(String[] args) {
        new LockTest().doTest();
    }
}
