package may21;

class Solution {
    public int countSquares(int[][] matrix) {
        int[][] ansMatrix=new int[matrix.length+1][matrix[0].length+1];
        int count=0;
        for(int i=1;i<ansMatrix.length;i++){
            for(int j=1;j<ansMatrix[i].length;j++){
                    if(matrix[i-1][j-1]==1){
                        ansMatrix[i][j]=Math.min(Math.min(ansMatrix[i-1][j],ansMatrix[i][j-1]),ansMatrix[i-1][j-1])+1;
                        count=count+ansMatrix[i][j];               
                    }
                
                
            }
        }
        return count;
        
        
    }
}