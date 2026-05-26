class Solution {
    public int numberOfSpecialChars(String word) {
        int answer=0;
        char[] ch=word.toCharArray();
        boolean[] lowercase=new boolean[26];
        boolean[] uppercase=new boolean[26];
        for(char c:ch){
            if(Character.isLowerCase(c)){
                lowercase[c-97]=true;
            } else{
                uppercase[c-65]=true;
            }
        }
        for(int i=0;i<26;i++){
            if(uppercase[i]&&lowercase[i]){
                answer++;
            }
        }
        return answer;
    }
}