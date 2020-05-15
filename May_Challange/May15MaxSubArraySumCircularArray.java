class Solution {
    int tempSum=0;
    public int maxSubarraySumCircular(int[] A) {
        //calculate Kaden's max subarray sum and total sum in single pass
        int maxSum = kaden(A,false);
        int totalSum = tempSum;//copy to total sum because it will change when we will calculate negative numbers
        int maxSumInverted = totalSum+ kaden(A,true); //caluclate maximum sum after inversion
        //maxSumInverted will be zero if all numbers are negative, In that case return old kaden's result
        return maxSumInverted==0?maxSum:Math.max(maxSumInverted,maxSum);
     
    }
    
    
    private int kaden(int[] A,boolean invert){
        int maxSoFar=Integer.MIN_VALUE;
        int maxTillNow=0;
        for(int i=0;i<A.length;i++){
            int number=!invert?A[i]:(-A[i]);
            tempSum= tempSum+number;
            maxTillNow= maxTillNow+number;
                if(maxTillNow>maxSoFar){
                    maxSoFar=maxTillNow;
                }
             if(maxTillNow<0){
                maxTillNow=0;
            }   
        }
        return maxSoFar;
    }
}