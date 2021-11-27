package StringAlgorithms.Solution;

public class AG_Sequence {
    public int solve(String A) {
        long ans = 0, count = 0;
        for(int i = A.length()-1; i >=0; i--) {
            if(A.charAt(i) == 'G') {
                count++;
            }
            if(A.charAt(i) == 'A') {
                ans = ans + count;
            }
        }
        return (int)(ans % 1000000007);
    }
    public static void main(String []s) {
        AG_Sequence m = new AG_Sequence();
        System.out.println(m.solve("AKHBGASLJKSDHGSDFAAGGGGGSADFGGG"));
        //ans = 38
    }
}
