import java.util.HashSet;

class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}

public class P31 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int arr[] = {1, 2, 3, 1};
        boolean result = s.containsDuplicate(arr);
        System.out.println(result);
    }
}
