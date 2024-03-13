package practice;

public class DPBasic {
    public static void main(String args[]){
        int n=18;
        int a[] = {7,5,1};
        int ans = minCoins(n, a);
        System.out.println(ans);

    }


    static int minCoins(int n, int a[]){
        if(n==0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++){
            if(n-a[i]>=0){
                int subAns = minCoins(n-a[i], a);

                if(subAns!=Integer.MAX_VALUE && subAns + 1<ans){
                    ans = subAns+1;
                }
            }
        }
        return ans;
    }
}
