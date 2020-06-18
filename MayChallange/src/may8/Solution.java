package may8;

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 6/11/2020
 */
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==2)
            return true;
        double baseSlope=calculateSlope(coordinates[0],coordinates[1]);
        for(int i=2;i<coordinates.length;i++){
            double slope=calculateSlope(coordinates[i],coordinates[1]);
            if(slope!=baseSlope)
                return false;
        }
        return true;

    }

    private double calculateSlope(int[] p1,int[] p2){
        return (double)(p2[1]-p1[1])/(double)(p2[0]-p1[0]);
    }

}
