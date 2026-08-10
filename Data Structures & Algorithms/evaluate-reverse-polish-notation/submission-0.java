class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++){
            int x;
            if (tokens[i].equals("+")){
                x = stack.pop() + stack.pop();
                stack.push(x);
            } else if (tokens[i].equals("-")){
                x = -stack.pop() + stack.pop();
                stack.push(x);
            } else if (tokens[i].equals("*")){
                x = stack.pop() * stack.pop();
                stack.push(x);
            } else if (tokens[i].equals("/")){
                int f = stack.pop();
                int s = stack.pop();
                x = s/f;
                stack.push(x);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
