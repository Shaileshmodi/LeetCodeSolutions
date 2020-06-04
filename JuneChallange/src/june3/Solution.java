package june3;

import java.util.Arrays;

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 6/4/2020
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {

        if(costs.length==1)
            return Math.min(costs[0][0],costs[0][1]);

        Arrays.sort(costs,(a, b)->a[0]-a[1]-(b[0]-b[1]));

        int result=0;

        for(int i=0;i<costs.length/2;i++){
            result=result+costs[i][0]+costs[costs.length-1-i][1];
        }

        return result;
    }
}
