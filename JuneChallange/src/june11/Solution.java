package june11;

class Solution {
    public void sortColors(int[] arr) {
       int low=0;
       int index=0;
       int high = arr.length-1;
      
        while(index<=high){
           if(arr[index]==0){
               swap(arr,low,index);
               low++;
               index++;
           }
           else if(arr[index]==1){
               index++;
           }
           else if(arr[index]==2){
               swap(arr,index,high);
               high--;
           }
       }
    }
    
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}