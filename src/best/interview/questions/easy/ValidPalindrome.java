package best.interview.questions.easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        String test1 = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome.isPalindromeNaive(test1));
        System.out.println(validPalindrome.isPalindrome(test1));

        String test2 = "race a car";
        System.out.println(validPalindrome.isPalindromeNaive(test2));
        System.out.println(validPalindrome.isPalindrome(test2));

        String test3 = " ";
        System.out.println(validPalindrome.isPalindromeNaive(test3));
        System.out.println(validPalindrome.isPalindrome(test3));
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindromeNaive(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(Character.toLowerCase(ch));
            }
        }
        for (int i = 0; i < result.length() / 2; i++) {
            if (result.charAt(i) != result.charAt(result.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
