package leetcode.solutions;

public class ThreeConsecutiveOnes1550 {
  public boolean threeConsecutiveOdds(int[] arr) {

    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 1) {
        count++;
      } else {
        count = Math.max(0, count - 1);
      }
      if (count == 3) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {

    ThreeConsecutiveOnes1550 obj = new ThreeConsecutiveOnes1550();
    System.out.println(obj.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
  }
}
