class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (int i = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)) != null){
                stack.push(s.charAt(i));
            } else {
                if (stack.size()!=0){
                    char x = stack.pop();
                    if (map.get(x) != s.charAt(i)) return false;
                } else {
                    return false;
                }
            }
        }
        if (stack.size()!=0) return false;
        return true;
    }
}
