class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        int max = 0;
        while (right < s.length()){//AAABABB,l=3,r=6,c=4,m=5,A1B3
            char c = s.charAt(right);
            if (map.get(c)!=null){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
            count++;
            if (count - map.get(highestFreq(map)) > k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                map.put(c,map.get(c)-1);
                left++;
                count-=2;
            } else {
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
    public char highestFreq(HashMap<Character, Integer> h){
        int max = 0;
        char c = 'a';
        for (Map.Entry<Character, Integer> entry : h.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
                c = entry.getKey();
            }
        }
        return c;
    }
}
