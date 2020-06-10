package june10;

class Solution {
    
    public int searchInsert(int[] nums, int target) {
        return searchIndex(nums,0,nums.length-1,target);
    }

    
    private int searchIndex(int[] nums,int low,int high,int target){
        
        if(low>high)
            return low;
        
        int mid=low+((high-low)/2);
        
        if(nums[mid]==target)
            return mid;
      
        if(nums[mid]<target){
            return searchIndex(nums,mid+1,high,target);
        }
        
       else{
            return searchIndex(nums,low,mid-1,target);
        }
        
        
        
        
        
    }
}