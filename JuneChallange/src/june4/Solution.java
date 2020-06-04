package june4;

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 6/4/2020
 */
class Solution {
    public void reverseString(char[] s) {
        if(s.length<=1)
            return;
        int low=0;
        int high=s.length-1;
        while(low<high){
            char temp=s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }
}