class Solution {
    int ans=Integer.MAX_VALUE;
    void f(int index, int amount, int[] coins, int total) {
        if(index < 0) return;
        if(amount==0) {
            ans=Math.min(ans,total);
            return;
        }
        if(coins[index]<=amount) {
            //take 
            f(index,amount-coins[index],coins, total+1);
            //not take
             f(index-1, amount, coins, total);
            
        } else {
            //not take
           f(index-1, amount, coins,total);
        }
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        ans=Integer.MAX_VALUE;
        f(n-1,amount,coins,0);
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}
