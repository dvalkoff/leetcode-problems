package best.interview.questions.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber.singleNumberNaive(nums));
        System.out.println(singleNumber.singleNumber(nums));

        nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber.singleNumberNaive(nums));
        System.out.println(singleNumber.singleNumber(nums));

        nums = new int[]{1};
        System.out.println(singleNumber.singleNumberNaive(nums));
        System.out.println(singleNumber.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public int singleNumberNaive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++count);
            }
        }

        for (var el : map.entrySet()) {
            if (el.getValue() == 1) {
                return el.getKey();
            }
        }
        return 0;
    }
}
