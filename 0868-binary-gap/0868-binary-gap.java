class Solution {
    public int binaryGap(int n) {
        int answer=0;
        char binary[]=Integer.toBinaryString(n).toCharArray();

        for(int i=0;i<binary.length;i++){
            if(binary[i]=='0')
                continue;
            for(int j=i+1;j<binary.length;j++){
                if(binary[j]=='1'){
                    answer=Math.max(answer,j-i);
                    i=j-1;
                    break;
                }
            }
        }
        return answer;
    }
}