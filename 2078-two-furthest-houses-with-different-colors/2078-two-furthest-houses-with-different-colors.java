class Solution {
    public int maxDistance(int[] colors) {
        int answer=0;
        for(int left=0;left<colors.length;left++){
            for(int right=left+1;right<colors.length;right++){
                if(colors[right]!=colors[left]){
                    answer=Math.max(answer,right-left);
                }
            }
        }

        return answer;
    }
}