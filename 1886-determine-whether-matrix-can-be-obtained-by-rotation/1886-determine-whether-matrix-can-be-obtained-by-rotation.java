class Solution {
    private int[][] rotate(int[][] prev){
        int[][] rotate_arr=new int[prev.length][prev[0].length];
        for(int r=0;r<prev.length;r++){
            for(int c=0;c<prev[r].length;c++){
                rotate_arr[r][c]=prev[c][prev[r].length-1-r];
            }
        }
        return rotate_arr;
    }
    private boolean isEqual(int[][] prev,int[][] mat){
        for(int r=0;r<mat.length;r++){
            for(int c=0;c<mat[r].length;c++){
                if(prev[r][c]!=mat[r][c])
                    return false;
            }
        }
        return true;
    }
    private void print(int[][] mat){
        for(int r=0;r<mat.length;r++){
            for(int c=0;c<mat[r].length;c++){
                System.out.print(mat[r][c]);
            }
            System.out.println();
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] prev=mat.clone();
        int[][] rotate_arr=rotate(prev);

        for(int i=0;i<4;i++){
            if(isEqual(target,rotate_arr)){
                return true;
            }
            // print(rotate_arr);
            // System.out.println();
            prev=rotate_arr.clone();
            rotate_arr=rotate(prev);
        }
        
        return false;
    }
}