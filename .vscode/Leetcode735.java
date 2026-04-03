import java.util.Stack;

public class Leetcode735 {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            outer:
            for (int ast : asteroids) {
                while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                    int top = stack.peek();
                    
                    if (Math.abs(top) < Math.abs(ast)) {
                        stack.pop();
                    } else if (Math.abs(top) == Math.abs(ast)) {
                        stack.pop();
                        continue outer;
                    } else {
                        continue outer; 
                    }
                }
                
                stack.push(ast);
            }

            int[] res = new int[stack.size()];
            for (int i = res.length - 1; i >= 0; i--) {
                res[i] = stack.pop();
            }
            return res;
        }
    }
}
