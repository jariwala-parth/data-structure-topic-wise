package leetcode;

// https://leetcode.com/problems/decode-string

//  My solution -
//  https://leetcode.com/problems/decode-string/solutions/5519475/easy-recursion-with-breaking-down-to-small-functions-java-beats-100-00/
public class DecodeString394 {

    int start = 0;

    public static void main(String[] args) {
        System.out.println("1->>>  " + new DecodeString394().decodeString("3[a]2[bc]"));
        //  o/p: aaabcbc
        System.out.println("2->>>  " + new DecodeString394().decodeString("3[a2[c]]"));
        //  o/p: accaccacc
        System.out.println("3->>>  " + new DecodeString394().decodeString("2[abc]3[cd]ef"));
        //  o/p: abcabccdcdcdef
        System.out.println("4->>>  " + new DecodeString394().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        // o/p: zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
    }

    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        return solve(arr).toString();
    }

    public StringBuilder solve(char[] arr) {
        StringBuilder sb = new StringBuilder();
        while (start < arr.length) {
            if (arr[start] >= 'a' && arr[start] <= 'z') {
                sb.append(arr[start++]);
            } else {
                sb.append(fixMathString(arr));
            }
        }
        return sb;
    }

    private StringBuilder fixMathString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        int count = findNumber(arr);
        while (start < arr.length) {
            if (arr[start] == '[') {
                start++;
            } else if (arr[start] >= 'a' && arr[start] <= 'z') {
                sb.append(arr[start++]);
            } else if (arr[start] == ']') {
                start++;
                break;
            } else if (arr[start] >= '0' && arr[start] <= '9') {
                sb.append(fixMathString(arr));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < count; i++) {
            ans.append(sb);
        }
        return ans;
    }

    private int findNumber(char[] arr) {
        int count = 0;
        while (arr[start] >= '0' && arr[start] <= '9') {
            count = count * 10 + arr[start] - '0';
            start++;
        }
        return count;
    }
}
