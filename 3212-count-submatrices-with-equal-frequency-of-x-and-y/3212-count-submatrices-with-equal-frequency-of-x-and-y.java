class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        // 1. 누적합 배열 정의 (0행 0열 처리를 쉽게 하기 위해 크기를 +1 추천)
        int R=grid.length;
        int C=grid[0].length;
        int[][][] sum = new int[R+ 1][C + 1][2];
        int ans=0;
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                // 일단 이전 값들로 누적합 기본 틀 복사
                sum[r][c][0] = sum[r-1][c][0] + sum[r][c-1][0] - sum[r-1][c-1][0];
                sum[r][c][1] = sum[r-1][c][1] + sum[r][c-1][1] - sum[r-1][c-1][1];

                // 현재 칸이 X인지 Y인지에 따라 해당 카운트만 +1
                char ch = grid[r-1][c-1];
                if (ch == 'X') sum[r][c][0]++;
                else if (ch == 'Y') sum[r][c][1]++;
                
                // 2. 조건 검사
                // X의 개수 > 0 이고, X의 개수 == Y의 개수 인지 확인
                if (sum[r][c][0] > 0 && sum[r][c][0] == sum[r][c][1]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}