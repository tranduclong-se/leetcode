import java.util.*;

public class Leetcode339 {
    class Edge {
        String to; // Đích đến (Ví dụ: "EUR")
        double value; // Tỉ giá

        Edge(String t, double v) {
            this.to = t;
            this.value = v;
        }
    }

    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            // Xây dựng đồ thị (Danh bạ tỉ giá)
            Map<String, List<Edge>> adj = new HashMap<>();
            for (int i = 0; i < equations.size(); i++) {
                String u = equations.get(i).get(0);
                String v = equations.get(i).get(1);
                double val = values[i];

                adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, val));
                adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, 1.0 / val));
            }

            // Xử lý từng câu hỏi
            double[] results = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String start = queries.get(i).get(0);
                String end = queries.get(i).get(1);

                // Nếu biến không tồn tại trong danh bạ
                if (!adj.containsKey(start) || !adj.containsKey(end)) {
                    results[i] = -1.0;
                } else if (start.equals(end)) {
                    results[i] = 1.0;
                } else {
                    // DFS đi tìm đường
                    results[i] = dfs(start, end, 1.0, adj, new HashSet<>());
                }
            }
            return results;
        }

        private double dfs(String curr, String target, double currentProduct,
                Map<String, List<Edge>> adj, Set<String> visited) {
            // Đánh dấu đã thăm để không đi vòng quanh
            visited.add(curr);

            // Duyệt qua các hàng xóm
            for (Edge edge : adj.get(curr)) {
                if (edge.to.equals(target)) {
                    return currentProduct * edge.value; // Tìm thấy đích!
                }

                if (!visited.contains(edge.to)) {
                    // Đi sâu xuống hàng xóm này
                    double result = dfs(edge.to, target, currentProduct * edge.value, adj, visited);
                    if (result != -1.0)
                        return result; // Nếu tìm thấy đường ở nhánh này, trả về luôn
                }
            }

            return -1.0; // Ngõ cụt
        }
    }
}