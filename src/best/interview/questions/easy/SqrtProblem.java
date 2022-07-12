package best.interview.questions.easy;

import java.util.EnumSet;

public class SqrtProblem {
    enum Aboba {
        ABOBA1, ABOBA2
    }
    public static void main(String[] args) {
//        EnumSet<Aboba> aboba1 = EnumSet.of(1);
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle <= x / middle && (middle + 1) > x / (middle + 1)) {
                return middle;
            }
            if (middle > x / middle) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

}
