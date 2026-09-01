class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] freq = new int[26];
        for(int i=0;i<tasks.length;i++) {
            freq[tasks[i]-'A']++;
        }
        for(int i=0;i<26;i++) {
            if(freq[i]>0)
                maxHeap.offer(freq[i]);
        }
        int time=1;
        while(!maxHeap.isEmpty()) {
            List<Integer>remaningTasks = new ArrayList<>();
            for(int i=0;i<=n;i++){
                    if(!maxHeap.isEmpty()) {
                    int task = maxHeap.poll();
                    task--;
                    if(task>0) remaningTasks.add(task);
                }
                if(maxHeap.isEmpty() && remaningTasks.isEmpty())  break;
                time++;
            }
            for(int task: remaningTasks) {
                maxHeap.offer(task);
            }
        }
        return time;
    }
}
/*
["X","X","Y","Y"]
[1,1+3,2,2+3]
[X,Y,X,Y]

["A","A","A","B","C"]
A---B---C---A
{A:3,B:1,C:1}
counter = 0 + 1 + 1 + 1 + 1
{A:3,B:1,C:1}--{idle,idle,idle}

1st:
{B:1,C:1} --{A:2,idle,idle}
2nd:
{C:1} -- {A:2, idle}
3rd:
{} -- {A:2}
4th:


*/