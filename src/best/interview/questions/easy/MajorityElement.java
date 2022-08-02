package best.interview.questions.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement.majorityElementNaive(nums));
        System.out.println(majorityElement.majorityElement(nums));
        int[] nums1 = {2, 2, 2, 4, 4, 4, 4};
        System.out.println(majorityElement.majorityElementNaive(nums));
        System.out.println(majorityElement.majorityElement(nums));
    }

    public int majorityElementNaive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer != null) {
                map.put(num, ++integer);
            } else {
                map.put(num, 1);
            }
        }
        return map.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .get().getKey();
    }


    public int majorityElement(int[] nums) {
        int votes = 1;
        int voted = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (voted == nums[i]) {
                votes++;
            } else {
                if (votes == 0) {
                    voted = nums[i];
                    votes = 1;
                } else {
                    votes--;
                }
            }
        }
        return voted;
    }
}
