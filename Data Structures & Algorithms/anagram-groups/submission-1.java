class Solution {
    String hash(String str){
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            String hs = hash(str);
            if(map.containsKey(hs)) {
                map.get(hs).add(str);
            } else {
                ArrayList<String>list = new ArrayList<>();
                list.add(str);
                map.put(hs,list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
