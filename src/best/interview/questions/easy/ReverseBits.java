package best.interview.questions.easy;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.revertBits(43261596));
        System.out.println(8 >> 1);
        System.out.println(-8 >> 1);

        System.out.println(8 >>> 1);
        System.out.println(-8 >>> 1);

    }

    public int revertBits(int n) {
        int reverted = 0x0;
        for (int i = 31; i >= 0; i--) {
            reverted |= (n & 0x80000000) >>> i;
            n <<= 1;
        }
        return reverted;
    }
}
