package leetcode.solutions;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(Character.toLowerCase(c));
            }
        }
        char[] arr = sb.toString().toCharArray();
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125 isPalindrome = new ValidPalindrome125();
        System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
