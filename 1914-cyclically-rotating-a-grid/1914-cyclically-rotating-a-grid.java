class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] answer = new int[m][n];

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> list = new ArrayList<>();

            // 1. 현재 layer 꺼내기
            for (int col = layer; col < n - 1 - layer; col++) {
                list.add(grid[layer][col]);
            }

            for (int row = layer; row < m - 1 - layer; row++) {
                list.add(grid[row][n - 1 - layer]);
            }

            for (int col = n - 1 - layer; col > layer; col--) {
                list.add(grid[m - 1 - layer][col]);
            }

            for (int row = m - 1 - layer; row > layer; row--) {
                list.add(grid[row][layer]);
            }

            int size = list.size();
            int rotate = k % size;

            int index = rotate;

            // 2. 회전된 값 다시 넣기
            for (int col = layer; col < n - 1 - layer; col++) {
                answer[layer][col] = list.get(index % size);
                index++;
            }

            for (int row = layer; row < m - 1 - layer; row++) {
                answer[row][n - 1 - layer] = list.get(index % size);
                index++;
            }

            for (int col = n - 1 - layer; col > layer; col--) {
                answer[m - 1 - layer][col] = list.get(index % size);
                index++;
            }

            for (int row = m - 1 - layer; row > layer; row--) {
                answer[row][layer] = list.get(index % size);
                index++;
            }
        }

        return answer;
    }
}