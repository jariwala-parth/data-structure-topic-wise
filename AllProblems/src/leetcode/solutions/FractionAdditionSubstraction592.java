package leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FractionAdditionSubstraction592 {
  public String fractionAddition(String expression) {

    Map<List<Integer>, List<Integer>> aByB = createExpression(expression);
    List<Integer> upper = aByB.keySet().iterator().next();
    List<Integer> lower = aByB.values().iterator().next();
    Integer denominator = lower.stream().reduce(1, (x, y) -> x * y);
    Integer numerator = 0;
    for (int i = 0; i < upper.size(); i++) {
      numerator += upper.get(i) * (denominator / lower.get(i));
    }

    if (numerator == 0) {
      return "0/1";
    }

    boolean negative = numerator < 0;
    int[] arr = removeCommonFractions(Math.abs(numerator), denominator);

    return (negative ? "-" : "") + arr[0] + "/" + arr[1];
  }

  public Map<List<Integer>, List<Integer>> createExpression(String expression) {
    Map<List<Integer>, List<Integer>> aByB = new HashMap<>();
    StringBuilder up = new StringBuilder();
    StringBuilder down = new StringBuilder();
    int i = 0;
    boolean upper = true;

    char isNegative = '+';
    List<Integer> upperList = new ArrayList<>();
    List<Integer> lowerList = new ArrayList<>();
    while (i < expression.length()) {
      char c = expression.charAt(i);
      if (c == '+' || c == '-') {
        upper = true;
        if (!up.isEmpty()) {
          upperList.add(Integer.parseInt(isNegative + up.toString()));
          lowerList.add(Integer.parseInt(down.toString()));
          up = new StringBuilder();
          down = new StringBuilder();
        }
        if (c == '-') {
          isNegative = '-';
        } else {
          isNegative = '+';
        }
      } else if (c == '/') {
        upper = false;
      } else {
        if (upper) {
          up.append(c);
        } else {
          down.append(c);
        }
      }

      i++;
    }
    if (!up.isEmpty()) {
      upperList.add(Integer.parseInt(isNegative + up.toString()));
      lowerList.add(Integer.parseInt(down.toString()));
    }
    aByB.put(upperList, lowerList);
    return aByB;
  }

  public static int[] removeCommonFractions(int a, int b) {
    int gcd = gcd(a, b);
    a /= gcd;
    b /= gcd;
    return new int[]{a, b};
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    FractionAdditionSubstraction592 fractionAdditionSubstraction592 = new FractionAdditionSubstraction592();
    System.out.println(fractionAdditionSubstraction592.fractionAddition("-1/2+1/2"));
    System.out.println(fractionAdditionSubstraction592.fractionAddition("-1/2+1/2+1/3"));
    System.out.println(fractionAdditionSubstraction592.fractionAddition("1/3-1/2"));
    System.out.println(fractionAdditionSubstraction592.fractionAddition("-1/2+1/6-2/5"));
  }
}
