package DynamicProgramming.Solution;

// https://leetcode.com/problems/find-the-town-judge/description/
public class FindTownJudge997 {

    public static void main(String[] args) {

        FindTownJudge997 obj = new FindTownJudge997();
        System.out.println(obj.findJudge(2, new int[][]{{1, 2}}));
        System.out.println(obj.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }

    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n + 1];
        int[] outgoing = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            outgoing[trust[i][0]]++;
            incoming[trust[i][1]]++;
        }
        int ans = -1, count = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("incoming[" + i + "] = " + incoming[i] + " outgoing[" + i + "] = " + outgoing[i]);
            if (incoming[i] == n - 1 && outgoing[i] == 0) {
                return ans;
            }
        }
        return -1;
    }
}
