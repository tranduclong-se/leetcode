//443.String Compression
public class Leetcode443 {
    class Solution {
        public int compress(char[] chars){
            int indexAns = 0; //con tro ghi ket qua
            int i = 0;        //con tro de doc mang

            while (i < chars.length) {
                char currentChar = chars[i];
                int count = 0;

                while (i < chars.length && chars[i] == currentChar) {
                    i++;
                    count++;
                }

                //ghi char[i] vao mang
                chars[indexAns++] = currentChar;

                //neu so luong > 1, ghi con so vao mang
                if(count>1){
                    //chuyen so count thanh chuoi de luu tung con so vao mang char
                    for(char c : Integer.toString(count).toCharArray()){
                        chars[indexAns++] = c;
                    }
                }
            }
            return indexAns;
        }
    }
}