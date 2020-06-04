package may23;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int low1=0;
        int low2=0;
        
        if(A.length==0 || B.length==0)
            return new int[0][0];
        
        List<int[]> list=new ArrayList<>(A.length);
 
        while(low1<A.length && low2<B.length){    
          int maxOfStart=Math.max(A[low1][0],B[low2][0]);
          int minOfEnd=Math.min(A[low1][1],B[low2][1]);
          
            if(minOfEnd>=maxOfStart){   
                 list.add(new int[]{maxOfStart,minOfEnd});   
            }
            if(minOfEnd==A[low1][1]){
                low1++;
            }
            else{
                low2++;
            }            
        }
        return list.toArray(new int[list.size()][2]);   
    }
}