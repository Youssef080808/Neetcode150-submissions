class Solution {
    public String minWindow(String s, String t) {
        String str = "";
        String strMax = "";
        HashMap<Character, Integer> mapFreq = new HashMap<>();
        HashMap<Character, Integer> mapCur = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            if (!mapFreq.containsKey(t.charAt(i))){
                mapFreq.put(t.charAt(i), 1);
            } else {
                mapFreq.put(t.charAt(i), mapFreq.get(t.charAt(i))+1);
            }
            mapCur.put(t.charAt(i), 0);
        }
        int left = 0;
        int right = 0;
        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 0;
        boolean found = false;//
        while (right < s.length()){
            if (mapCur.containsKey(s.charAt(right))){
                mapCur.put(s.charAt(right),mapCur.get(s.charAt(right))+1);
            }
            if (matchFreq(mapFreq, mapCur)){
                while (matchFreq(mapFreq, mapCur)){
                    if (mapCur.containsKey(s.charAt(left))){
                        mapCur.put(s.charAt(left), mapCur.get(s.charAt(left))-1);
                    }
                    left++;
                }
                if (!found || right - left + 2 < arr[1] - arr[0] + 1){
                    arr[0] = left-1;
                    arr[1] = right;
                    found = true;//
                }
            }
            right++;
        }
        return found ? s.substring(arr[0], arr[1] + 1) : "";//
    }
    private boolean matchFreq(HashMap<Character, Integer> mapFreq,        HashMap<Character, Integer> mapCur) {
    for (Character c : mapFreq.keySet()) {
        if (mapCur.get(c) < mapFreq.get(c)) {
            return false;
        }
    }
    return true;
}
}
