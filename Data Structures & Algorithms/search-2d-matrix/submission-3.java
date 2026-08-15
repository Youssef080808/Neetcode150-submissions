class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int high = row*col-1;
        int low = 0;
        while (low<=high){
            int mid = (high+low)/2;
            int val = matrix[mid / col][mid % col];
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
