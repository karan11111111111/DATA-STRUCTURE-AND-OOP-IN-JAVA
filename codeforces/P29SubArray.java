

class maxSubArray{
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int currSum = 0;
        int maxSum = 0;
        for(int i=0; i<n; i++){
            currSum = Math.max(arr[i],  currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);

        }
        return maxSum;
    
        
    }

}

public class P29SubArray {
    public static void main(String[] args) {
        
    
   maxSubArray S = new maxSubArray();
   int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
   int result = S.maxSubArray(arr);
   System.out.println("result = "+ result);

   
    }
}
