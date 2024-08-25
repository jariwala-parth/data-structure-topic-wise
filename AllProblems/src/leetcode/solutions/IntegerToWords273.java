package leetcode.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToWords273 {

  public String numberToWords(int num) {
    String n = String.valueOf(num);

    Map<Integer, List<String>> map = new HashMap<>();
    map.put(1, List.of("One"));
    map.put(2, List.of("Two", "Twenty"));
    map.put(3, List.of("Three", "Thirty"));
    map.put(4, List.of("Four", "Forty"));
    map.put(5, List.of("Five", "Fifty"));
    map.put(6, List.of("Six", "Sixty"));
    map.put(7, List.of("Seven", "Seventy"));
    map.put(8, List.of("Eight", "Eighty"));
    map.put(9, List.of("Nine", "Ninety"));
    StringBuilder ans = new StringBuilder();
    for (int i = n.length() - 1; i >=0 ; i -= 3) {
      String subString = n.substring(Math.max(0, i - 3), i);
//      ans.append();
    }
    return ans.toString();
  }

  public static void main(String[] args) {

    IntegerToWords273 obj = new IntegerToWords273();
    System.out.println(obj.numberToWords(123));
    System.out.println(obj.numberToWords(12345));
    System.out.println(obj.numberToWords(1234567));
    System.out.println(obj.numberToWords(4567823));
  }
}
