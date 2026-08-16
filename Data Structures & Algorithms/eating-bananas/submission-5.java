class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++){
            if (piles[i] > max) max=piles[i];
        }
        int low = 1;
        int high = max;
        int answer = max;
        while (low <= high){
            int mid = (high+low)/2;
            int count = 0;
            for(int i = 0; i < piles.length; i++){
                count += (piles[i]+mid-1)/mid;
            }
            if (count <= h){
                answer = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return answer;
    }
}//[1,12,3,2], h=9, k=3
// [1,2,3,12], total=18/9 = 2 so minimum rate is k=2
// max k is [1,1,1,1,1,1,1,1,10]k=10, maybe max k is largest value k=12