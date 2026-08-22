class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        int total = lenA+lenB;
        int half = total/2;
        int low = -1;
        int high = lenA-1;
        boolean isEven = (total % 2 == 0);
        while (low<=high){
            int mid = Math.floorDiv(high+low, 2); // first array (A) pointer
            int ptr = half - mid - 2; // second array (B) pointer
            int aLeft = (mid >= 0) ? nums1[mid] : Integer.MIN_VALUE;
            int aRight = (mid+1 < lenA) ? nums1[mid+1]:Integer.MAX_VALUE;
            int bLeft = (ptr >= 0) ? nums2[ptr] : Integer.MIN_VALUE;
            int bRight = (ptr+1 < lenB) ? nums2[ptr+1]:Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight){
                if (isEven){
                    int left = Math.max(aLeft,bLeft);
                    int right = Math.min(aRight, bRight);
                    return (double) (left+right)/2;
                }
                return (double) Math.min(aRight, bRight);
            } else if (bLeft > aRight){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
