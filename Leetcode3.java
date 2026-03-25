//3. Longest Substring Without Repeating Characters
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int max=0;
        HashSet<Character>set = new HashSet<>();
        while(right<s.length()){
            char c = s.charAt(right); 
            //neu ky tu da co trong cua so
            while(set.contains(c)){
                //Thu hep cua so ben trai
                set.remove(s.charAt(left));
                left++;
            }
            //Them ky tu moi vao cua so truot va mo rong ben pha
            set.add(c);
            max= Math.max(max, right-left+1);
            right++;            
        }
        return max;
    }
}

public class Leetcode3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        System.out.println("Input: s = \"" + s + "\"");
        System.out.println("=".repeat(50));

        int left = 0;
        int right = 0;
        int max = 0;
        int step = 1;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            System.out.println("\nBuoc " + step + ": Xet s[" + right + "] = '" + c + "'");

            // Thu hep cua so neu ky tu da ton tai
            while (set.contains(c)) {
                System.out.println("  -> '" + c + "' da co trong set " + set);
                System.out.println("  -> Xoa s[" + left + "] = '" + s.charAt(left) + "', left di chuyen " + left + " -> " + (left + 1));
                set.remove(s.charAt(left));
                left++;
            }

            // Them ky tu moi vao set
            set.add(c);
            max = Math.max(max, right - left + 1);

            String window = s.substring(left, right + 1);
            System.out.println("  -> Them '" + c + "' vao set");
            System.out.println("  -> Cua so hien tai: [" + left + ", " + right + "] = \"" + window + "\"");
            System.out.println("  -> Set = " + set);
            System.out.println("  -> Do dai = " + (right - left + 1) + ", Max = " + max);

            right++;
            step++;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Ket qua: Do dai chuoi con dai nhat khong lap = " + max);
        System.out.println("Goi ham thuc te: " + solution.lengthOfLongestSubstring(s));
    }
}