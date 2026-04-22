class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> answer=new ArrayList<String>();
        int length=queries[0].length();
        
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<dictionary.length;j++){
                int distance=0;
                char[] queriesSplit=queries[i].toCharArray();
                char[] dictionarySplit=dictionary[j].toCharArray();
                for(int k=0;k<length;k++){
                    if(queriesSplit[k]!=dictionarySplit[k]){
                        distance++;
                    }
                }
                if(distance<=2){
                    answer.add(queries[i]);
                    break;
                }
            }
        }
        return answer;
    }
}