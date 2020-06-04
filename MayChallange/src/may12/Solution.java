package may12;

class Solution {
    
    public int singleNonDuplicate(int[] nums) {
    int low=0;
    int high=nums.length-1;
    
        while(low<high){
        int mid=low+(high-low)/2;
        if((mid%2)==0){
        /* if mid is even then Expected behavior- next element should be equal to mid. 
        If not, There is a problem at left hand side else search for right side*/
            if(nums[mid]!=nums[mid+1]){
                high=mid;//include mid to because we know that same value can be there in left side
            }
            else{
                low=mid+2; //mid and mid+1 are equal so we can skip them
            }
            
            
        }
            else{
                
          /* if mid is odd then Expected behavior- previous element should be equal to mid. 
        If not, There is a problem at left hand side else search for right side*/
            if(nums[mid]!=nums[mid-1]){
                high=mid;//include mid to because we know that same value can be there in left side
            }
            else{
                low=mid+1; //mid and mid+1 are equal so we can skip them
            }
                
                
            }
            
        
    }    
        return nums[low];
        
    }
    
    

}
