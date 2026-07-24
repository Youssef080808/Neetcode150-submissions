class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] seq = new int[len];
        int starts = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            set.add(nums[i]);
        }
        for (int i = 0; i < len; i++){
            if (!set.contains(nums[i]-1)){
                seq[starts] = nums[i];
                starts++;
            }
        }
        int count = 0;
        int counter = 0;
        for (int i = 0; i < starts; i++){
            counter = 0;
            int cur = seq[i];
            for(int j = 0; j < nums.length-starts; j++){
                if (set.contains(cur+1)){
                    counter++;
                    cur = cur + 1;
                }
            }
            if (counter > count){
                count = counter;
            }
        }
        return count + 1;
    }
}
