class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }   
        int fleetCount = 0;
        double maxTime = 0;
        Arrays.sort(cars, (a, b) -> b[0] - a[0]); //descending by position
        for (int i = 0; i < cars.length; i++){
            double targetTime = (double)(target - cars[i][0]) /cars[i][1];
            if (targetTime > maxTime){ 
                fleetCount++;
                maxTime = targetTime;
            }
        }
        return fleetCount;
    }
}
