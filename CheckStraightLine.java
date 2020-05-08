/**
Problem: You are given an array coordinates,
coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
Check if these points make a straight line in the XY plane.

Solution: The solution is pretty simple if we understand the logic of coordinates at straight line. 
Two coordinates are at same line if their slope is same. Means three points [x1,y1] and [x2,y2] [x3,y3] are on same line if their slope 
with any other point is same.

Slope for two points [x1,y1] and [x2.y2]
slope =(y2-y1)/(x2-x1)

So we will calculate the base slope from first two points and check any two points have same slope.

P.S: We will use double to avoid ArithmaticException(1/0)

@author: Shailesh Modi
**/
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
