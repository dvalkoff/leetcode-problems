package best.interview.questions.easy;

import java.util.Arrays;


public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    int[] newDigits = new int[digits.length + 1];
                    System.arraycopy(digits, 0, newDigits, 1, digits.length);
                    newDigits[0] = 1;
                    digits = newDigits;
                }
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        return digits;
    }
}
