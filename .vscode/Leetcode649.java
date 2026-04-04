import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        // Bước 1: Phân loại index vào 2 hàng đợi
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.add(i);
            else dire.add(i);
        }

        // Bước 2: Bỏ phiếu cho đến khi một phe hết người
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // Ai có index nhỏ hơn thì ra tay trước
            if (rIndex < dIndex) {
                // Radiant thắng lượt này, quay lại hàng đợi cho lượt sau (n)
                radiant.add(rIndex + n);
            } else {
                // Dire thắng lượt này
                dire.add(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}