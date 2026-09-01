class Twitter {
    HashMap<Integer,Set<Integer>> followers;
    HashMap<Integer,Set<Tweet>> tweets;
    int timer;

     static class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }


    public Twitter() {
        this.followers = new HashMap<>();
        this.tweets = new HashMap<>();
         
        timer=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timer++;
        if(tweets.containsKey(userId)) {
            tweets.get(userId).add(new Tweet(tweetId,timer));
        } else {
            tweets.put(userId,new HashSet<>());
            tweets.get(userId).add(new Tweet(tweetId,timer));
        }

        


    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer>followers = new HashSet<>();
        if(this.followers.containsKey(userId)) {
            followers = this.followers.get(userId); 
        }
            PriorityQueue<Tweet> pq = new PriorityQueue<>((t1,t2)->Integer.compare(t1.time,t2.time));
            if(tweets.containsKey(userId)) {
            for(Tweet t: tweets.get(userId)) {
                    pq.offer(t);
                    if(pq.size()>10) pq.poll();
                } 
            }
            
            for(int follower: followers){
                if(tweets.containsKey(follower)) {
                for(Tweet t: tweets.get(follower)) {
                    pq.offer(t);
                    if(pq.size()>10) pq.poll();
                } }
            }
            List<Integer>ans = new ArrayList<>();
            while(!pq.isEmpty()) {
                ans.add(pq.poll().id);
            }
            Collections.reverse(ans);
            return ans;
        
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)) {
            followers.put(followerId,new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId) && followers.get(followerId).contains(followeeId)){
            followers.get(followerId).remove(followeeId);
        }
        
    }
}
