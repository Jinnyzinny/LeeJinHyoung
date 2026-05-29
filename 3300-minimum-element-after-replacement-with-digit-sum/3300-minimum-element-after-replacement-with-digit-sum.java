class Solution {
    public int minElement(int[] nums) {
        int answer=Integer.MAX_VALUE;
        for(int i:nums){
            answer=Math.min(answer,String.valueOf(i)
                        .chars()
                        .map(c -> c - '0')
                        .sum());
        }
        return answer;
    }
}