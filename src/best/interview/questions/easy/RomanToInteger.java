package best.interview.questions.easy;

import java.util.Map;

public class RomanToInteger {
    private static final Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int value = map.get(s.charAt(i));
            int nextValue = map.get(s.charAt(i + 1));
            if (nextValue > value) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result + map.get(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        int result1 = romanToInteger.romanToInt("III");
        System.out.println(result1);
        int result2 = romanToInteger.romanToInt("LVIII");
        System.out.println(result2);
        int result3 = romanToInteger.romanToInt("MCMXCIV");
        System.out.println(result3);
    }
}
