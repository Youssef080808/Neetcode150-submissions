class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++){//pwwkew l=3,c=3,kew,m=3
            if (set.contains(s.charAt(i))){
                max = Math.max(count, max);
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(left));
                    left++;
                    count--;
                }
                set.add(s.charAt(i));
                count++;
            } else {
                count++;
                set.add(s.charAt(i));
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
