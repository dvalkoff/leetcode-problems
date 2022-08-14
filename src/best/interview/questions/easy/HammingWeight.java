package best.interview.questions.easy;

public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(-64));
    }

    public int hammingWeight(int n) {
        int mask = 1;
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                counter++;
            }
            n >>>= 1;
        }
        return counter;
    }
}
