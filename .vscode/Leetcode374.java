public class Leetcode374 {
    /**
     * Forward declaration of guess API.
     * 
     * @param num your guess
     * @return -1 if num is higher than the picked number
     *         1 if num is lower than the picked number
     *         otherwise return 0
     *         int guess(int num);
     */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1;
            int hight = n;
            while (low <= hight) {
                int mid = low + (hight - low) / 2;

                int result = guess(mid);
                if (result == 0) {
                    return mid;
                } else if (result == -1) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        private int guess(int mid) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'guess'");
        }
    }
}
