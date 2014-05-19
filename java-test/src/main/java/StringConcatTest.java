import java.sql.Time;

/**
 * Test string concat method in Java
 */
public class StringConcatTest {
    public static void main(String[] args) {
        new StringBuilderTest().run();
        new StringBufferTest().run();
        new StringRawConcatTest().run();
        new StringConcatMethodTest().run();
    }

    public static abstract class TimedTest {
        int COUNT = 10000000;

        public void run() {
            System.out.println(this.getClass().getSimpleName() + " start");
            long start = System.nanoTime();
            doRun();
            long end = System.nanoTime();
            double dur = (end - start) / 1000000.0;
            double durPerRun = dur / COUNT;
            System.out.println(String.format("total time %fms, time per run %fms\n", dur, durPerRun));
        }

        abstract void doRun();
    }

    public static class StringBuilderTest extends TimedTest {

        @Override
        void doRun() {
            String str = "";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < COUNT; i++) {
                sb.append("abc");
            }
        }
    }

    public static class StringBufferTest extends TimedTest {

        @Override
        void doRun() {
            String str = "";
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < COUNT; i++) {
                sb.append("abc");
            }
        }
    }

    public static class StringRawConcatTest extends TimedTest {

        @Override
        void doRun() {
            String str = "";
            for (int i = 0; i < COUNT; i++) {
                str += "abc";
            }
        }
    }

    public static class StringConcatMethodTest extends TimedTest {
        @Override
        void doRun() {
            String str = "";
            for (int i = 0; i < COUNT; i++) {
                str = str.concat("abc");
            }
        }
    }
}
