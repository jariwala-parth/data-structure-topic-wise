package leetcode.solutions;

public class FillingBookSelves1105 {
  public int minHeightShelves(int[][] books, int shelfWidth) {
    if (books.length == 0) {
      return 0;
    }
    int[] dp = new int[books.length + 1];
    for (int i = 1; i <= books.length; i++) {
      int thickness = books[i - 1][0], h = books[i - 1][1];
      dp[i] = dp[i - 1] + h;
      for (int j = i - 1; j > 0; j--) {
        thickness += books[j - 1][0];
        if (thickness > shelfWidth) {
          break;
        }
        h = Math.max(h, books[j - 1][1]);
        dp[i] = Math.min(dp[i], dp[j - 1] + h);
      }

    }
    return dp[books.length];
  }

  public int solveRec(int[][] books, int index, int currentWidth, int currentLevelHeight, int shelfWidth) {
    if (index == books.length) {
      return currentLevelHeight;
    }
    int thickness = books[index][0], h = books[index][1];
    if (currentWidth + thickness > shelfWidth) {
      // new level, current height increase by h
      return currentLevelHeight + solveRec(books, index + 1, 0, h, shelfWidth);
    } else {
      return Math.min(
          solveRec(books, index + 1, currentWidth + thickness, Math.max(currentLevelHeight, h), shelfWidth),
          currentLevelHeight + solveRec(books, index + 1, 0, h, shelfWidth));
    }
  }

  public static void main(String[] args) {
    FillingBookSelves1105 fillingBookSelves1105 = new FillingBookSelves1105();
//    System.out.println(fillingBookSelves1105.minHeightShelves(new int[][]{{1, 3}, {2, 4},{3, 2}}, 6));
    System.out.println(fillingBookSelves1105.minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 2}}, 4));
//    System.out.println(fillingBookSelves1105.minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}}, 4));
//    System.out.println(fillingBookSelves1105.minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4));
  }
}
