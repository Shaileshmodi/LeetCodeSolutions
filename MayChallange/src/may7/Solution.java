package may7;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(count==0){
                candidate=nums[i];
            }
                count+=(candidate==nums[i])?1:-1;
        }
        return candidate;
        
    }
}