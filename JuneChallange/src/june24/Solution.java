package june24;

class Solution {
    public int numTrees(int n) {
       
         Integer [] dp=new Integer[n+1];
      
        //numTreesRec(n,dp);
        numTreesBottomTop(n,dp);
        return dp[dp.length-1];
        
        
    }
    
    private int numTreesRec(int n,Integer[] dp){
        if(n==0 || n==1)
            return dp[n]=1;
        if(dp[n]!=null)
            return dp[n];
        dp[n]=0;
        for(int i=1;i<=n;i++){
         dp[n]+=numTreesRec(i-1,dp)*numTreesRec(n-i,dp);    
        }
        return dp[n];
    }
    
    private void numTreesBottomTop(int n,Integer[] dp){
       dp[0]=1;
       dp[1]=1; 
        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
    }
    }
    
   
}