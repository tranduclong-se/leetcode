public class Leetcode547 {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }
    private void dfs(int city, int[][] isConnected, boolean[] visited){
        visited[city] = true;
        // Duyệt qua tất cả các thành phố khác để tìm xem cái nào kết nối với thành phố hiện tại
        for( int i = 0; i<isConnected.length; i++){
            if(isConnected[city][i] == 1 && !visited[i]){
                dfs(i, isConnected, visited);
            }
        }
    }
}