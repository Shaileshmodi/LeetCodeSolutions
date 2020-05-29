/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 *
 * @author shailesh.modi
 * @version 1.0.0
 * @since 5/29/2020
 */
public class May28CountingBits {

    public int[] countBits(int num) {
        if(num==0)
            return new int[]{0};
        int[] array=new int[num+1];
        array[0]=0;
        for(int i=1;i<=num;i++){
            array[i]=array[i>>1]+(i&1);
        }

        return array;

    }

    public static void main(String[] args) {
        May28CountingBits may28CountingBits=new May28CountingBits();
        may28CountingBits.countBits(2);
        may28CountingBits.countBits(5);
    }
}
