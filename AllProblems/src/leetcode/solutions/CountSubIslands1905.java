package leetcode.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class CountSubIslands1905 {
  public static void main(String[] args) {

    CountSubIslands1905 obj = new CountSubIslands1905();
    System.out.println(obj.countSubIslands(new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}}, new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}}));
    System.out.println(obj.countSubIslands(new int[][]{{1, 1, 1, 1, 0, 0}, {1, 1, 0, 1, 0, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 0}}, new int[][]{{1, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 0, 0}}));
  }

  private static class Pair {
    int u;
    int v;

    Pair(int u, int v) {
      this.u = u;
      this.v = v;
    }

    @Override
    public boolean equals(Object obj) {
      Pair p = (Pair) obj;
      return (p.u == this.u && p.v == this.v);
    }

    @Override
    public String toString() {
      return u + ":" + v;
    }
  }

  public int countSubIslands(int[][] grid1, int[][] grid2) {
    List<Set<Pair>> islands = findIslands(grid2);
    System.out.println(islands);
    int ans = 0;
    for (Set<Pair> island : islands) {
      AtomicBoolean isSubIsland = new AtomicBoolean(true);
      island.forEach(p -> {
        if (grid1[p.u][p.v] == 0) {
          isSubIsland.set(false);
        }
      });
      ans += isSubIsland.get() ? 1 : 0;
    }
    return ans;
  }

  public List<Set<Pair>> findIslands(int[][] grid) {
    List<Set<Pair>> islands = new ArrayList<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          Set<Pair> island = new HashSet<>();
          dfs(grid, i, j, island, visited);
          islands.add(island);
        }
      }
    }
    return islands;
  }

  public void dfs(int[][] grid, int i, int j, Set<Pair> island, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
      return;
    }
    visited[i][j] = true;
    island.add(new Pair(i, j));
    dfs(grid, i + 1, j, island, visited);
    dfs(grid, i - 1, j, island, visited);
    dfs(grid, i, j + 1, island, visited);
  }
}
