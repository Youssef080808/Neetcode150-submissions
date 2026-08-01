class Solution {
    public int trap(int[] height) {
        int rp = height.length-1;
        int lp = 0;
        int amt = 0;
        int leftMax = height[lp];
        int rightMax = height[rp];
        while (lp < rp){
            if (leftMax <= rightMax){
                lp++;
                leftMax = Math.max(leftMax, height[lp]);
                amt += leftMax - height[lp];
            } else {
                rp--;
                rightMax = Math.max(rightMax, height[rp]);
                amt += rightMax - height[rp];
            }
        }
        return amt;
    }
}
