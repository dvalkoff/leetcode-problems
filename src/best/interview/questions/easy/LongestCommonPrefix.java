package best.interview.questions.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder longestPrefix = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            while (!str.startsWith(longestPrefix.toString())) {
                longestPrefix.replace(longestPrefix.length() - 1, longestPrefix.length(), "");
            }
        }
        return longestPrefix.toString();
    }

    public static void main(String[] args) {
        String result = new LongestCommonPrefix()
                .longestCommonPrefix(
                new String[]{"abab","abab","aba"}
        );
        System.out.println(result);
    }
}
