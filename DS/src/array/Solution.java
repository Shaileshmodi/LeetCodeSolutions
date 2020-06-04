package array;

import java.util.Arrays;

/**
 *
 * @author shailesh.modi
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] products=new int[nums.length];
        products[0]=1;
        
        for(int i=1;i<nums.length;i++){
            products[i]=products[i-1]*nums[i-1];
        }
        
        int temp=1;
        
        for(int i=nums.length-1;i>=0;i--){
            products[i]*=temp;
            temp*=nums[i];
        }
        return products;
    }


    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] result=solution.productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(result));
    }
}