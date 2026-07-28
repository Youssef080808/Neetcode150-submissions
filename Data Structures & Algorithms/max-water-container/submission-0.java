class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;
        int max = 0;
        int p1 = 0;
        int p2 = len-1;
        for (int i = 0; i < len; i++){
            int height;
            if (heights[p1] > heights[p2]){
                height = heights[p2];
            } else {
                height = heights[p1];
            }
            int sum = (p2-p1)*height;
            if (sum > max) max = sum;
            if (heights[p1] > heights[p2]){
                p2--;
            } else if (heights[p1] < heights[p2]){
                p1++;
            } else {
                p1++;
                p2--;
            }
        }
        return max;
    }
}
