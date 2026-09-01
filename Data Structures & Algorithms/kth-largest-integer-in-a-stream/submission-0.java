class KthLargest {
    PriorityQueue<Integer>minHeap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        int n=nums.length;
        this.k=k;
        for(int i=0;i<n;i++){
            minHeap.offer(nums[i]);
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
         if(minHeap.size()>k) {
                minHeap.poll();
        }
        return minHeap.peek();
    }
}
//min heap of k=4 size[10,19,21,22] [23, 34,45]
