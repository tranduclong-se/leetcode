import java.util.ArrayList;
import java.util.List;

public class Leetcode1466 {
    class Solution {
        public int minReorder(int n, int[][] connections) {
            List<List<int[]>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());

            for (int[] c : connections) {
                adj.get(c[0]).add(new int[] { c[1], 1 }); // Đường gốc
                adj.get(c[1]).add(new int[] { c[0], 0 }); // Đường ngược
            }

            boolean[] visited = new boolean[n];
            return dfs(0, adj, visited);
        }

        private int dfs(int u, List<List<int[]>> adj, boolean[] visited) {
            visited[u] = true;
            int changes = 0;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int cost = neighbor[1];

                if (!visited[v]) {
                    // Nếu đường gốc đi từ u -> v (xa rời thành phố 0), tăng count
                    changes += cost + dfs(v, adj, visited);
                }
            }
            return changes;
        }
    }
}
