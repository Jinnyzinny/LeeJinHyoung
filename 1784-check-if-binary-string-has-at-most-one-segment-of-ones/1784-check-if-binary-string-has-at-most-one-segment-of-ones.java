class Solution {
    public boolean checkOnesSegment(String s) {
        char[] ch=s.toCharArray();
        int number=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='0')
                continue;
            while(i<ch.length&&ch[i]=='1'){
                i++;
            }
            number++;
        }
        return number==1?true:false;
    }
}