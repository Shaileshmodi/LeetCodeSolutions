package june18;

class Solution {
    public int hIndex(int[] citations) {
        int low=0;
        int high=citations.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int expected=citations.length-mid;
            int value=citations[mid];
            if(value<expected){
                low=mid+1;
            }
            else{
                 high=mid-1; 
            }
        }
        System.out.println("low is"+low);
        
        return citations.length-low;       
    }
    
    
    
    
    
}