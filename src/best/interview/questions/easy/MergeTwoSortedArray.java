package best.interview.questions.easy;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        new MergeTwoSortedArray().mergeStartWithTheEnd(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{1};
        nums2 = new int[]{};
        new MergeTwoSortedArray().mergeStartWithTheEnd(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        new MergeTwoSortedArray().mergeStartWithTheEnd(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{4, 5, 0, 0};
        nums2 = new int[]{1, 2};
        new MergeTwoSortedArray().mergeStartWithTheEnd(nums1, 2, nums2, 2);
        System.out.println(Arrays.toString(nums1));

    }

    public void merge(int[] dest, int m, int[] nums2, int n) {
        int[] nums1 = new int[m];
        System.arraycopy(dest, 0, nums1, 0, m);
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                dest[i + j] = nums1[i];
                i++;
            } else {
                dest[i + j] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            dest[i + j] = nums1[i];
            i++;
        }

        while (j < n) {
            dest[i + j] = nums2[j];
            j++;
        }
    }

    public void mergeStartWithTheEnd(int[] nums1, int m, int[] nums2, int n) {
         m--;
         n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m--];
            } else {
                nums1[m + n + 1] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[m + n + 1] = nums2[n--];
        }

    }
}
