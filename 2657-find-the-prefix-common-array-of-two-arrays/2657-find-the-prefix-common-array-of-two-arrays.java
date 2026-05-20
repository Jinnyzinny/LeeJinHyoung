class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] C=new int[A.length];
        Set<Integer> setA=new HashSet<Integer>();
        Set<Integer> setB=new HashSet<Integer>();

        for(int i=0;i<A.length;i++){
            setA.add(A[i]);
            setB.add(B[i]);
            C[i]=(int) setA.stream().filter(setB::contains).count();
        }
        return C;
    }
}