class Solution {
    public boolean isGood(int[] nums) {
        int[] check=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=check.length){
                return false;
            }
            check[nums[i]]++;
        }
        if(check[check.length-1]>2||check[check.length-1]<2){
            return false;
        }
        for(int i=1;i<check.length-1;i++){
            if(check[i]<1||check[i]>1){
                return false;
            }
        }
        return true;
    }
}