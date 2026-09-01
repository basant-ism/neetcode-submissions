class Solution {

    public String encode(List<String> strs) {
        String ans = "";
        for(int i=0;i<strs.size();i++){
            ans+=strs.get(i).length();
            ans+="#";
            ans+=strs.get(i);
        }
        return ans;

    }

    public List<String> decode(String str) {
        int n=str.length();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            String numStr="";
            while(ch!='#' && i<n){
                numStr+=ch;
                i++;
                ch = str.charAt(i);
            }
            int len = Integer.parseInt(numStr);
            ans.add(str.substring(i+1,i+1+len));
            i+=len;
        }
        return ans;

    }
    //["Hello","Worldd"]
    //5#Hello6#Worldd
}
