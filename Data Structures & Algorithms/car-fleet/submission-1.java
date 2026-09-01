class Solution {
    class Pair implements Comparable<Pair> {
        int pos;
        int speed;

        Pair(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
        @Override
        public int compareTo(Pair p) {
            return Integer.compare(p.pos, this.pos);
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(arr);
        Deque<Double> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            Pair p = arr[i];
            Double time = (target-p.pos)/(double)p.speed;
            if(stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
