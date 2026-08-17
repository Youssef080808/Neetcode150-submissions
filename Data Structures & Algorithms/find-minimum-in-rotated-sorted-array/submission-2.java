class Solution {
    public int findMin(int[] nums) {
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length;i++){
            count = Math.min(count, nums[i]);
        }
        return count;
    }
}
