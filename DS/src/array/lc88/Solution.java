package array.lc88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int high=nums1.length-1;
        int high1=m-1;
        int high2=n-1;
        
        while(high1>=0 && high2>=0){
            
            if(nums1[high1]>nums2[high2]){
                nums1[high--]=nums1[high1--];
            }
            else{
              nums1[high--]=nums2[high2--];   
            }
        }
        
        while(high2>=0){
            nums1[high--]=nums2[high2--];
        }
        
        
        
    }
}