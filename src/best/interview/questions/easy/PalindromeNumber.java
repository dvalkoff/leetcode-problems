package best.interview.questions.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int[] arr = new int[10];
        short i = 0;
        while (x != 0) {
            arr[i++] = x % 10;
            x /= 10;
        }
        for (short j = 0; j < i / 2; j++) {
            if (arr[j] != arr[i - j - 1]){
                return false;
            }
        }
        return true;
    }
}
