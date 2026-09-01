class Solution {
    class Pair {
        int num;
        int freq;
        Pair(int num, int freq) {
            this.num=num;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> freq = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(!freq.containsKey(nums[i])) {
                freq.put(nums[i],0);
            }
            freq.put(nums[i],freq.get(nums[i])+1);
        }

        List<Integer>[] f = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            f[i]=new ArrayList<>();
        }

        for(int key : freq.keySet()){
            f[freq.get(key)].add(key);
        }

        int[] ans = new int[k];
        int j=0;
        for(int i=n;i>0;i--){
            int a=f[i].size()-1;
            while(a>=0) {
                ans[j] = f[i].get(a);
                j++;
                a--;
                if(j>=k) break;
            }
            if(j>=k) break;
            
        }
        return ans;

        // HashMap<Integer,Integer> freq = new HashMap<>();
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     if(!freq.containsKey(nums[i])) {
        //         freq.put(nums[i],0);
        //     }
        //     freq.put(nums[i],freq.get(nums[i])+1);
        // }
        // PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p1.freq,p2.freq));
        // for(int key: freq.keySet()) {
        //     Pair p = new Pair(key,freq.get(key));
        //     pq.offer(p);
        //     if(pq.size()>k) pq.poll();
        // }
        // int[] ans = new int[k];
        // int i=0;
        // while(!pq.isEmpty()){
        //     ans[i]=pq.poll().num;
        //     i++;
        // }
        // return ans;
        
    }
}
