class Solution {
    public boolean answer;
    public void dfs(String[] split,int index,String s2){
        if(index==split.length){
            String joined=String.join("",split);
            if(joined.equals(s2)){
                answer=true;
            }
            return;
        }
        dfs(split,index+1,s2);
        if(index>=2){
            String temp=split[index];
            split[index]=split[index-2];
            split[index-2]=temp;
            dfs(split,index+1,s2);
        }
    }   
    public boolean canBeEqual(String s1, String s2) {
        answer=false;
        String[] split=s1.split("");
        dfs(split,0,s2);
        return answer;
    }
}