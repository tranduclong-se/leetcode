public class Leetcode2215 {

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Bước 1: Đưa các phần tử vào Set để loại bỏ trùng lặp và tra cứu O(1)
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) set1.add(n);
        
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) set2.add(n);
        
        // Bước 2: Tạo danh sách kết quả
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // list cho nums1
        result.add(new ArrayList<>()); // list cho nums2
        
        // Bước 3: Tìm phần tử có trong set1 nhưng không có trong set2
        for (int n : set1) {
            if (!set2.contains(n)) {
                result.get(0).add(n);
            }
        }
        
        // Bước 4: Tìm phần tử có trong set2 nhưng không có trong set1
        for (int n : set2) {
            if (!set1.contains(n)) {
                result.get(1).add(n);
            }
        }
        
        return result;
    }
}