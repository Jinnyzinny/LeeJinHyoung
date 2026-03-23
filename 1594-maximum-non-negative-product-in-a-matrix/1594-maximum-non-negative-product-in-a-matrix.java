class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] maxPath = new long[m][n];
        long[][] minPath = new long[m][n];

        // 초기값 설정
        maxPath[0][0] = minPath[0][0] = grid[0][0];

        // 첫 번째 열/행 채우기
        for (int i = 1; i < m; i++) {
            maxPath[i][0] = minPath[i][0] = maxPath[i - 1][0] * grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            maxPath[0][j] = minPath[0][j] = maxPath[0][j - 1] * grid[0][j];
        }

        // DP 진행
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxPath[i][j] = Math.max(maxPath[i - 1][j], maxPath[i][j - 1]) * grid[i][j];
                    minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) * grid[i][j];
                } else {
                    // 음수일 때는 이전의 최소값이 현재의 최대값이 됨
                    maxPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) * grid[i][j];
                    minPath[i][j] = Math.max(maxPath[i - 1][j], maxPath[i][j - 1]) * grid[i][j];
                }
            }
        }

        long res = maxPath[m - 1][n - 1];
        return res < 0 ? -1 : (int) (res % 1000000007);
    }
}