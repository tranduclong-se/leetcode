//345. Reverse Vowels of a String
public class Problems345 {
    class Solution {
        public String reverseVowels(String s) {
            char[] word = s.toCharArray();
            int left = 0;
            int right= s.length() - 1;
            String vowels = "aeiouAEIOU"; // cac nguyen am
            while (left < right) {
                // Tim nguyen am trai
                while (left < right && vowels.indexOf(word[left]) == -1) {
                    left ++;
                }
                while (left < right && vowels.indexOf(word[right]) == -1) {
                    right --;
                }
                //swap left vowel <=> right vowel
                char temp = word[left];
                word[left] = word[right];
                word[right] = temp;
                //di chuyen tep sau khi swap
                left++;
                right++;
            }
            return new String(word);
        }
    }
}
