package sorthing;

public class subsetSum {
    static boolean isSubsetSum(int[] set, int n, int sum){
       boolean[][] subset = new boolean[n+1][sum+1];

       for(int i =0; i<=n; i++){
           if(i==0){
            subset[0][i] = false;
           }
       }
       for(int i=0; i<=sum; i++){
        if(i==0){
            subset[i][0] = true;
        }
       }

       for(int i=1; i<=n+1; i++){
        for(int j=1; j<=sum+1; j++){

        }
       }
    }

     public static void main(String args[]){

     }
    
}
