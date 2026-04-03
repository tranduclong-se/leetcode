import java.util.Stack;

public class Leetcode394 {
    class Solution {
        public String decodeString(String s) {
            Stack<Integer> countStack = new Stack<>();
            Stack<StringBuilder> resStack = new Stack<>();
            
            StringBuilder currentRes = new StringBuilder();
            int k = 0;

            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    k = k * 10 + (ch - '0');
                } else if (ch == '[') {
                    countStack.push(k);
                    resStack.push(currentRes);
                    //  Reset 
                    currentRes = new StringBuilder();
                    k = 0;
                } else if (ch == ']') {
                    int repeatTimes = countStack.pop();
                    StringBuilder decodedString = resStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        decodedString.append(currentRes);
                    }
                    //Cập nhật currentRes thành chuỗi đã ghép xong
                    currentRes = decodedString;
                } else {
                    // Nếu là ký tự bình thường, chỉ cần append
                    currentRes.append(ch);
                }
            }

            return currentRes.toString();
        }
    }
}
