package june6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 6/6/2020
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0];
            else
                return a[1] - b[1];

        });
        for(int i=0;i<people.length;i++) {
            System.out.print(Arrays.toString(people[i]));
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            result.add(people[i][1], people[i]);
        }

        return result.toArray(new int[people.length][]);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int input[][] = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] op=solution.reconstructQueue(input);
        System.out.println("\n");
        for(int i=0;i<op.length;i++) {

            System.out.print(Arrays.toString(op[i]));
        }
    }
}