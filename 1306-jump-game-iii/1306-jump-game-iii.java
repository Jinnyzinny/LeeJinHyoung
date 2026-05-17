class Solution {
    private class Node{
        int count;
        int index;
        public Node(int count,int index){
            this.count=count;
            this.index=index;
        }
    }
    public boolean bfs(int[] arr,int start){
        boolean[] vis=new boolean[arr.length];
        Queue<Node> q=new ArrayDeque<>();
        q.offer(new Node(0,start));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(arr[cur.index]==0)
                return true;

            if(vis[cur.index])
                continue;
            vis[cur.index]=true;

            if(cur.index-arr[cur.index]>=0)
                q.offer(new Node(cur.count+1,cur.index-arr[cur.index]));
            if(cur.index+arr[cur.index]<arr.length)
                q.offer(new Node(cur.count+1,cur.index+arr[cur.index])); 
        }
        return false;
    }
    public boolean canReach(int[] arr, int start) {
        return bfs(arr,start);
    }
}