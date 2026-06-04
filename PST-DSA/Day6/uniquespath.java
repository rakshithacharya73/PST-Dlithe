package PSTDSA.Day6;
//leetcode-62
//unique paths
public class uniquespath {
    public static int findpath(int row, int col) {
        int[][] grid = new int[row][col];
        for (int left = 0; left < row; left++) {
            grid[left][0] = 1;
        }
        for (int right = 0; right < col; right++)
            grid[0][right] = 1;
        for (int left = 1; left < row; left++) {
            for (int right = 1; right < col; right++)
                grid[left][right] = grid[left - 1][right] + grid[left][right - 1];
        }
        return grid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int row = 3, col = 7;
        System.out.println(findpath(row, col));
         row = 2; col = 3;
        System.out.println(findpath(row, col));
         row = 3; col = 2;
        System.out.println(findpath(row, col));
    }
}
