package best.interview.questions.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val != null && val == i) {
                return new int[]{i, val};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
