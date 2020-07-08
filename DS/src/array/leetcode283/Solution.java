package array.leetcode283;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        moveZerosCT(nums);
    }
    
    private void moveZerosCT(int[] nums){
        if(nums.length==0)
            return;
        int low=0;
        for(int num:nums){
            if(num!=0)
                nums[low++]=num;
        }
        while(low<nums.length){
            nums[low++]=0;    
        }    
    }
    
    private void moveZerosWithExtraSpace(int[] nums){ 
        int[] result=new int[nums.length];
        int firstIndex=0,lastIndex=nums.length-1;
        for(int num:nums){
            if(num==0){
                result[lastIndex--]=0;
            }
            else{
                result[firstIndex++]=num;
            }
        }
        //copy to nums
       for(int i=0;i<result.length;i++){
           nums[i]=result[i];
       }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{ 0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}