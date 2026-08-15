class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int high = row*col-1;
        int low = 0;
        while (low<=high){
            int mid = (high+low)/2;
            int val = matrix[mid / col][mid % col];// mid/col tells how 
            // many cols passed, mid%col tells how far into list. treat 
            // question as one long array.
            if (val == target) return true;
            if (val < target){
                low = mid+1; 
            } else {
                high = mid-1;
            }
        }
        return false;
    }
}
