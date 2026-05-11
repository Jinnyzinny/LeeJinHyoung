class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> answer=new ArrayList<>();
        for(int i:nums){
            int[] split=Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
            for(int j:split){
                answer.add(j);
            }
        }
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}