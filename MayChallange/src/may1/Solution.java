package may1;

/**

Problem:
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.


@author: Shailesh Modi
**/
class Solution {
    public boolean isPerfectSquare(int num) {
     int low=1;
     int high=num;
     int lastDigit=num%10;   
        
     if(lastDigit==3 || lastDigit==7 ||lastDigit==2 || lastDigit ==8)
         return false;
        
     while(low<=high){
         //we will not take mid*mid because it is causing integer overflow
         int mid=low+(high-low)/2;
         int result=num/mid;//should be qual to mid and remainder should be zero
         int rem=num%mid;
         if(result==mid && rem==0)
             return true;
         //if result is less than mid than reduce high
         if(result<mid){
             high=mid-1;
         }
         else{
             low=mid+1;
         }
     }      
        return false;
        
    }
}
