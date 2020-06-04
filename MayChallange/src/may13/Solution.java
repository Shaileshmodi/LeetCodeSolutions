package may13;

class Solution {
    public String removeKdigits(String num, int k) {
        if (k==num.length())
            return "0";     
        StringBuilder sb=new StringBuilder(num);
        for(int x=0;x<k;x++){
        
            int index=0;
            while(index<sb.length()-1 && sb.charAt(index)<=sb.charAt(index+1)){
                index++;
            }
            sb.delete(index,index+1);
            while(sb.length()>1 && sb.charAt(0)=='0'){
                sb.delete(0,1);
            } 
        }
        return sb.toString();
        
        
    }
}