class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++){
            while(stack.size() != 0 && temperatures[i] > temperatures[stack.peek()]){
                results[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return results;
    }
}