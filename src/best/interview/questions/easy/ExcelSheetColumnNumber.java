package best.interview.questions.easy;

import org.jetbrains.annotations.NotNull;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        var columnNumber = new ExcelSheetColumnNumber();

        System.out.println(columnNumber.titleToNumber("AB"));
        System.out.println(columnNumber.titleToNumber("BB"));
    }

    public int titleToNumber(@NotNull String columnTitle) {
        int alphabetLength = 26, sum = 0;
        char charBeforeA = 'A' - 1;

        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            sum += (columnTitle.charAt(i) - charBeforeA)
                    * Math.pow(alphabetLength, columnTitle.length() - i - 1);
        }

        return sum;
    }


}
