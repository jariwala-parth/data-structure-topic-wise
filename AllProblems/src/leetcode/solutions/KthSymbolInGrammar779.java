package leetcode.solutions;

public class KthSymbolInGrammar779 {

    // 1        0                               1
    // 2        0            1                  2
    // 3        01           10                 4
    // 4        0110         1001               8
    // 5        01101001     10010110           16
    public int kthGrammar(int n, int k) {
        if (n <= 2) {
            return (k + 1) % 2;
        }
        int l = 1 << (n - 1);
        System.out.println("n=" + n + " k=" + k + " l=" + l);
        StringBuilder ans = new StringBuilder();
        if (k <= l / 2) {
            ans = makeString(new StringBuilder("0"), 0, k - 1);
        } else {
            ans = makeString(new StringBuilder("1"), 1, (k - 1)- l / 2);
        }
        return ans.charAt(0) - '0';
    }

    StringBuilder makeString(StringBuilder sb, int start, int k) {
        if (start == k)  {
            return sb;
        }
        if (start < k / 2) {
            sb.append(0);
            sb = makeString(sb, start + 1, k);
        } else {
            sb.append(1);
            sb = makeString(sb, start + 1, k);
        }
        return sb;
    }

    public static void main(String[] args) {
        KthSymbolInGrammar779 obj = new KthSymbolInGrammar779();
        System.out.println(obj.kthGrammar(1, 1));
        System.out.println(obj.kthGrammar(2, 1));
        System.out.println(obj.kthGrammar(3, 2));
        System.out.println(obj.kthGrammar(4, 2));
        System.out.println(obj.kthGrammar(5, 1));
    }
}
