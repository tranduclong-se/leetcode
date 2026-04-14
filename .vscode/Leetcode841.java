import java.util.List;
import java.util.Stack;

public class Leetcode841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited[0] = true;
        int count = 1; //Đếm số phòng đã mở

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            
            for(int key : rooms.get(currentRoom)){
                if(!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                    count++;
                }
            }
        }
        return count == n;
    }
}
