class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temp.length;
        int index =0;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
        
    }
}
