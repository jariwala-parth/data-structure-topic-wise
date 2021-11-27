package BitManipulation.Solution;

public class StrangeEquality {
    public static void main(String[] args) {
        StrangeEquality strangeEquality = new StrangeEquality();
        System.out.println(strangeEquality.solve(1));  // 2
        System.out.println(strangeEquality.solve(2));  // 5
        System.out.println(strangeEquality.solve(5));  // 10
        System.out.println(strangeEquality.solve(10)); // 21
    }

    public int solve(int A) {
        int bits = 0, a = A;

        while (a > 0) {
            bits++;
            a = (a >> 1);
        }

        int y = (1 << (bits));

        int x = 0, withoutMSB = ((1 << (bits - 1)) ^ A);
        if (bits > 1) {
            x = (1 << (bits - 1)) - 1;
            x = x ^ withoutMSB;
        }

        return x + y;
    }

    // Explanation:
    // For value > A, it should be one bit more than # of bits of A. So, it can be 1 << (log(A)).
    // For Finding greatest smaller element than A,
    // It should be of one bit smaller than A and all (b-1) bits should be inverted (If 1 then 0, if 0 then 1).
    // i.e. for A = 5 -> 0101
    // Y (>A) should be -> 1000
    // X (<A) should be ->   0101, so 01 and if we invert bits -> 10.
    // S0, x = 10 = 2, y = 1000 = 8. Ans = 2 + 8 = 10.
}
