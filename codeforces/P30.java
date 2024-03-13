

class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        
        for (int i =0;  i<n; i++){
            for (int j=0; j<n-i-1; j++){
                if(nums[i] == nums[j]){
                    return true;
                    
                }
               
            }


        }

        return false;
    }
}

public class P30 {
    public static void main(String[] args) {
        
    
    Solution2 s = new Solution2();
    int arr[] = {1,2,3,1};
    boolean result = s.containsDuplicate(arr);
    System.out.println(result);
    } 
}
