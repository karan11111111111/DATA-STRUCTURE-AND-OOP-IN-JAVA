

class Solution{
    public static int maxSubArray(int[] nums){
        int n = nums.length;
        for(int i =0; i<n; i++){
            for(int j=0; j<n-i-1; j++ ){
                if(nums[j+1]<nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        int sum = nums[n-2]+nums[n-1];
        return sum;

    }
}

public class P28 {
    public static void main(String[] args) {
        
    

    Solution S = new Solution();

    int nums[] = {1,8,7,0,2};

   int result = S.maxSubArray(nums);
    System.out.println("Result = "+ result);
 
    } 
}
