package topicPlus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 m 行 n 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * DFS
 * new 一个 boolean[][] 后，里面默认是false
 */
public class 面试题0802机器人 {
    private int m;
    private int n;
    private int[][] grid;

    public List<List<Integer>> pathWithObstacles(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, 0, new boolean[m][n], res);
        return res;
    }

    private boolean dfs(int row, int col, boolean[][] visited, List<List<Integer>> res) {
        if (row >= m || col >= n || grid[row][col] == 1 || visited[row][col]) {
            return false;
        }

        res.add(Arrays.asList(row, col));
        if (row == m - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;

        if (dfs(row + 1, col, visited, res) || dfs(row, col + 1, visited, res)) {
            return true;
        }

        res.remove(res.size() - 1);
        return false;
    }
}
