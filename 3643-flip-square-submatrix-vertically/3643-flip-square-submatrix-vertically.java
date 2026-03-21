class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int[][] area=new int[k][k];

        for(int r=x;r<x+k;r++){
            for(int c=y;c<y+k;c++){
                area[area.length-1-(r-x)][c-y]=grid[r][c];
            }
        }
        int[][] answer=new int[grid.length][grid[0].length];
        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                answer[i][j]=area[i-x][j-y];
            }
        }
        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer[i].length;j++){
                if(answer[i][j]>0)
                    continue;
                answer[i][j]=grid[i][j];
            }
        }
        return answer;
    }
}