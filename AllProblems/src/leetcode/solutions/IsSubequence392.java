package leetcode.solutions;

public class IsSubequence392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int start = 0;
        for (int i = 0; i < tt.length && start < ss.length; i++) {
            if (ss[start] == tt[i]) {
                start++;
            }
        }
        return ss.length == start;
    }

    public static void main(String[] args) {
        IsSubequence392 isSubequence = new IsSubequence392();
        System.out.println(isSubequence.isSubsequence("abc", "ahbgdc"));
    }
}
