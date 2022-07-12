package best.interview.questions.easy;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class IndexOfImplementation {

    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            byte[] array = new byte[7];
            random.nextBytes(array);
            byte[] array1 = new byte[4];
            String haystack = new String(array, StandardCharsets.UTF_8);
            String needle = new String(array1, StandardCharsets.UTF_8);
            System.out.println("needle = " + needle);
            System.out.println("haystack = " + haystack);
            if (strStr(haystack, needle) != haystack.indexOf(needle)) {
                throw new RuntimeException();
            }
        }
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isBlank()){
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        byte[] haystack1 = haystack.getBytes();
        byte[] needle1 = needle.getBytes();

        for (int i = 0; i < haystack1.length; i++) {
            if (haystack1.length - i < needle1.length) {
                break;
            }
            for (int j = 0; j < needle1.length; j++) {
                if (haystack1[i + j] != needle1[j]) {
                    break;
                }
                if (needle1.length - 1 == j) {
                    return i;
                }
            }
        }
        return -1;
    }
}
