//392. Is Subsequence
public class Leetcode392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length()==0) return true;

            int i=0; 
            int j=0;
            while (j<t.length()) {
                // Nếu ký tự khớp, cho i tiến lên
                if(s.charAt(i) == t.charAt(j))
                    i++;
                // Nếu i đã đi hết chuỗi s, dừng lại và trả về true
                if(i==s.length()) {
                    return true;
                }
                j++;
            }
            return i == s.length();
        }
    }
}   
