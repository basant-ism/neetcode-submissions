class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && h[stack.peek()] >= h[i]){
                stack.pop();
            }
            if(!stack.isEmpty())  {
                left[i] = stack.peek() + 1;
            } 
            stack.push(i);
        }
        stack = new ArrayDeque<>();
        Arrays.fill(right, n-1);
        for(int i=n-1;i>=0;i--){
             while(!stack.isEmpty() && h[stack.peek()] >= h[i]){
                stack.pop();
            }
            if(!stack.isEmpty())  {
                right[i] = stack.peek() - 1;
            } 
            stack.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int area = (right[i] - left[i] + 1) * h[i];
            ans = Math.max(ans, area);
        }
        return ans;
        
    }
}
