package may26;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 5/27/2020
 */
class Solution {
    public int findMaxLength(int[] nums) {

        if(nums.length<=1)
            return 0;

        int maxLength=0;
        int length=0;

        Map<Integer,Integer> map=new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            length=length+(nums[i]==1?1:-1);

            if(map.containsKey(length)){
                int tmp=i-(map.get(length)+1)+1;
                if(tmp>maxLength)
                    maxLength=tmp;
            }
            else if(length==0){
                int tmp=i+1;
                if((i+1)>maxLength)
                    maxLength=tmp;
            }
            else
                map.put(length,i);
        }
        return maxLength;
    }
}