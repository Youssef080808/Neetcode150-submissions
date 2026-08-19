class TimeMap {
    HashMap<String, List<List<String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (timeMap.get(key) == null){
            List<List<String>> arr = new ArrayList<>();
            List<String> arr2 = new ArrayList<>();
            arr2.add(String.valueOf(timestamp));
            arr2.add(value);
            arr.add(arr2);
            timeMap.put(key, arr);
        } else {
            List<String> arr2 = new ArrayList<>();
            arr2.add(String.valueOf(timestamp));
            arr2.add(value);
            timeMap.get(key).add(arr2);
        }
    }
    
    public String get(String key, int timestamp) {
        List<List<String>> arr1 = timeMap.get(key);
        if (arr1 == null) return "";
        int best = 0;
        String ans = "";
        int high = arr1.size()-1;
        int low = 0;
        while(low <= high){
            int mid = (high+low+1)/2;
            List<String> arr2 = arr1.get(mid);
            if (Integer.parseInt(arr2.get(0)) == timestamp) return arr2.get(1);
            if (Integer.parseInt(arr2.get(0)) > timestamp){
                high = mid-1;
            } else {
                low = mid+1;
                ans = arr2.get(1);
            }
        }
        return ans;
    }
}// a hashmap that when i get key it returns a list of all the timestamps 
// with the associated values
