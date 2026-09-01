class Solution {
    class Tuple {
        int x;
        int y;
        int d;
        Tuple(int x, int y, int d) {
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    int dis_sqr(int x, int y) {
        return x*x + y*y;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple>maxHeap = new PriorityQueue<>((t1,t2)->Integer.compare(t2.d,t1.d));
        int n=points.length;
        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
            int d= dis_sqr(x,y);
            maxHeap.offer(new Tuple(x,y,d));
            if(maxHeap.size()>k) maxHeap.poll();
        }
        int[][] ans = new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty()) {
            Tuple t = maxHeap.poll();
            ans[i][0]=t.x;
            ans[i][1]=t.y;
            i++;
        }
        return ans;
    }
}
