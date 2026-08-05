class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> s1Map = new HashSet<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s1.length(); i++){//s1=adc,s2=dcda,l=0,r=4
            if (!map.containsKey(s1.charAt(i))){//a0d1c0
                map.put(s1.charAt(i), 1);
            } else {
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            }
        }
        while (right < s2.length()){
            if (map.containsKey(s2.charAt(right))){
                map.put(s2.charAt(right), map.get(s2.charAt(right))-1);
            }
            right++;
            if (right - left > s1.length()){
                if (map.containsKey(s2.charAt(left))){
                    map.put(s2.charAt(left), map.get(s2.charAt(left))+1);
                }
                left++;
            }
            if (allZero(map)) return true;
        }
        return false;
    }
    private boolean allZero(HashMap<Character, Integer> map) {
        for (int count : map.values()) {
            if (count != 0) return false;
        }
        return true;
    }
}
