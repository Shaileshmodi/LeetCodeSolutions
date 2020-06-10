package june5;

import java.util.Arrays;
import java.util.Random;

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 6/6/2020
 */
class Solution {
    private int[] prefixSum=null;
    Random rand = new Random();
    public Solution(int[] w) {
        int prev=0;
        this.prefixSum=new int[w.length];
        for(int i=0;i<w.length;i++){
            this.prefixSum[i]=prev+w[i];
            prev= this.prefixSum[i];
        }
    }

    public int pickIndex() {
        int lastIndex=prefixSum.length-1;
        int int_random = 1+rand.nextInt(prefixSum[lastIndex]);

        int p = Arrays.binarySearch(prefixSum, int_random);
        return p >= 0 ? p : -p - 1;

        //return findNumber(int_random,0,lastIndex);
    }

    private int findNumber(int number,int min,int max){

        if(min>=max)
            return min;

        int mid=min+(max-min)/2;
        int lastNumber=(mid-1)<0?1:prefixSum[mid-1];
        if(number>lastNumber && number<=prefixSum[mid]){
            return mid;
        }
        else if(number>prefixSum[mid]){
            return findNumber(number,mid+1,max);

        }
        else{
            return findNumber(number,min,mid-1);
        }

    }

    public static void main(String[] args) {
        Solution solution=new Solution(new int[]{2,3,1,4});
        solution.pickIndex();
    }



}

