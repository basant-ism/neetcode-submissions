class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n= stones.length;
        for(int i=0;i<n;i++) maxHeap.offer(stones[i]);
        while(maxHeap.size() > 1) {
            int x=maxHeap.poll();
            int y=maxHeap.poll();
            if(x==y)continue;
            maxHeap.offer(x-y);
        }
        if(maxHeap.size()==1) return maxHeap.peek();
        return 0;
    }
}
