class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        long[] row = new long[grid.length];
        long[] col = new long[grid[0].length];

        // 1. 행의 합, 열의 합, 전체 합을 동시에 구합니다.
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                row[r] += grid[r][c];
                col[c] += grid[r][c];
                total += grid[r][c];
            }
        }

        // 전체 합이 홀수면 무조건 false
        if (total % 2 != 0) return false;
        long target = total / 2;

        // 2. 가로로 자를 수 있는지 확인 (행의 누적 합)
        long rowRunningSum = 0;
        for (int r = 0; r < row.length - 1; r++) { // 마지막 행 제외 (나눠야 하니까)
            rowRunningSum += row[r]; // 이전 행들의 합을 계속 더해나감
            if (rowRunningSum == target) return true;
        }

        // 3. 세로로 자를 수 있는지 확인 (열의 누적 합)
        long colRunningSum = 0;
        for (int c = 0; c < col.length - 1; c++) { // 마지막 열 제외
            colRunningSum += col[c]; // 이전 열들의 합을 계속 더해나감
            if (colRunningSum == target) return true;
        }

        return false;
    }
}