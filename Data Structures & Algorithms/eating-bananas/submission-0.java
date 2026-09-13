class Solution {
    int takenHours(int[] piles, int speed) {
        int n = piles.length;
        int hours = 0;
        for(int i=0;i<n;i++){
            hours+=(piles[i] + speed - 1) / speed;
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int mx = piles[0];
        for(int i=1;i<n;i++) {
            mx = Math.max(mx, piles[i]);
        }
        int l = 1;
        int r = mx;
        int ans = -1;
        while(l<=r) {
            int mid = l + (r - l)/2;
            int hours = takenHours(piles, mid);
            if(hours <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    /*
    0 1 2 3 4 5 6 7
    F F T T T
    */
}
