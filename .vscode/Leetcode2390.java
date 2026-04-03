public class Leetcode2390 {

    class Solution {
        public String removeStars(String s) {
            int n = s.length();
            char[] result = new char[n];
            int p = 0;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '*') {
                    if (p > 0) p--; 
                } else {
                    result[p] = c;
                    p++;
                }
            }

            return new String(result, 0, p);
        }
    }
}