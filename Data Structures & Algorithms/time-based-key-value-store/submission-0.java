class TimeMap {
    Map<String,List<Pair>> map;

    static class Pair {
        String value;
        int time;
        Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).add(new Pair(value, timestamp));
        } else {
            map.put(key, new ArrayList<>());
            map.get(key).add(new Pair(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int l = 0;
        int r = list.size() - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid).time <= timestamp) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(ans == -1) return "";
        return list.get(ans).value;

    }
}
