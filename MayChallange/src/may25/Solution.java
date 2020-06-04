package may25; /**
 * Problem:
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 *
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 *
 * A[i] == B[j];
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 *
 * Return the maximum number of connecting lines we can draw in this way.
 */

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 5/25/2020
 */
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {

        //Approach1 : Max UncrossedLines using top to bottom approach  --Faster
        return maxUncrossedLinesTabular(A,B);

        //Approach 2 : Max UncrossedLines using top to bottom approach(Memoization)
        //Take Integer because we want to differentiate between null and zero
        //Integer[][] dp=new Integer[A.length][B.length];
        //return maxUncrossedLines(A,B,0,0,dp);
    }

    private int maxUncrossedLinesTabular(int[] A, int[] B){
        if(A.length==0 || B.length==0)
            return 0;


        int[][] temp=new int[A.length+1][B.length+1];
        //by default all zeros

        for(int i=1;i<temp.length;i++){
            for(int j=1;j<temp[i].length;j++){
                if(A[i-1]==B[j-1]){
                    temp[i][j]=1+temp[i-1][j-1];
                }
                else{
                    temp[i][j]=Math.max(temp[i-1][j],temp[i][j-1]);
                }
            }
        }
        return temp[temp.length-1][temp[0].length-1];
    }


    private int maxUncrossedLines(int[] A,int[]B,int i,int j,Integer[][] dp){
        if(i>=A.length || j>=B.length)
            return 0;

        if(dp[i][j]!=null)
            return dp[i][j];

        if(A[i]==B[j]){
            dp[i][j]=1+maxUncrossedLines(A,B,i+1,j+1,dp);
        }
        else{
            dp[i][j]=Math.max(maxUncrossedLines(A,B,i+1,j,dp),maxUncrossedLines(A,B,i,j+1,dp));
        }

        return dp[i][j];
    }
}