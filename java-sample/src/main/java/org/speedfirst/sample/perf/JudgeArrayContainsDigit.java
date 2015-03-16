package org.speedfirst.sample.perf;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author jiankuan
 * @since 1/14/15
 */
public class JudgeArrayContainsDigit {

    public static final String testCase = "abcdefghijklmnopqrstuvmwxyz123abcdefghijklmnopqrstuvmwxyz";

    public interface JudgeContainsDigit {
        public boolean judge(String text);
    }
    public static class SimpleMethod implements JudgeContainsDigit {

        @Override
        public boolean judge(String text) {
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if ('0' <= c && c <= '9') {
                    return true;
                }
            }

            return false;
        }
    }

    public static class SimpleCopyArrayMethod implements JudgeContainsDigit {

        @Override
        public boolean judge(String text) {
            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if ('0' <= c && c <= '9') {
                    return true;
                }
            }

            return false;
        }
    }

    public static class IterateMethod implements JudgeContainsDigit {

        @Override
        public boolean judge(String text) {
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                for (char j = '0'; j <= '9'; j++) {
                    if (c == j) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static class IsDigitMethod implements JudgeContainsDigit {

        @Override
        public boolean judge(String text) {
            for (int i = 0; i < text.length(); i++) {
                if (Character.isDigit(text.charAt(i))) {
                    return true;
                }
            }

            return false;
        }
    }

    public static class RegexMethod implements JudgeContainsDigit {

        @Override
        public boolean judge(String text) {
            return text.matches(".*\\d+.*");
        }
    }

    public static class PreCompiledRegexMethod implements JudgeContainsDigit {

        Pattern pattern = Pattern.compile(".*\\d+.*");
        @Override
        public boolean judge(String text) {
            return pattern.matcher(text).matches();
        }
    }

    public static class Regex2Method implements JudgeContainsDigit {

        @Override
        public boolean judge(String text) {
            return text.matches(".*[0-9]+.*");
        }
    }

    public static class RegexFindMethod implements JudgeContainsDigit {

        Pattern pattern = Pattern.compile("[0-9]");
        @Override
        public boolean judge(String text) {
            return pattern.matcher(text).find();
        }
    }

    public static class StringUtilsMethod implements JudgeContainsDigit {

        @Override
        public boolean judge(String text) {
            return StringUtils.containsAny(text, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        }
    }

    public static void main(String[] args) {
        JudgeArrayContainsDigit j = new JudgeArrayContainsDigit();
        run(new SimpleMethod());
        run(new SimpleCopyArrayMethod());
        run(new IterateMethod());
        run(new IsDigitMethod());
        run(new RegexMethod());
        run(new PreCompiledRegexMethod());
        run(new Regex2Method());
        run(new RegexFindMethod());
        run(new StringUtilsMethod());
    }

    public static void run(JudgeContainsDigit judger) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            judger.judge(testCase);
        }
        long end = System.nanoTime();
        System.out.println(String.format("%s: %,dms", judger.getClass().getName(), (end - start) / 1000000));
    }
}
