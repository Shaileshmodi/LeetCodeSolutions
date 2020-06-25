package june21;

class Solution {
  
    public int calculateMinimumHP(int[][] dungeon) {
          int [][] dp=new int[dungeon.length][dungeon[0].length];
         for(int i=0;i<dp.length;i++){
              for(int j=0;j<dp[0].length;j++){
                  dp[i][j]=Integer.MIN_VALUE;
              }
          }
       return calculateMinimumHP(dungeon,dp,0,0); 
    }
    
    
     public int calculateMinimumHP(int[][] dungeon,int[][] dp,int x,int y) {
        
        if(x>=dungeon.length || y>=dungeon[x].length){
            return Integer.MAX_VALUE;
        }
        
         if((x==dungeon.length-1) && (y==dungeon[x].length-1)){
             dp[x][y]=1-dungeon[x][y];
             dp[x][y]= Math.max(1,dp[x][y]);
             return dp[x][y];
         }
         if(dp[x][y]!=Integer.MIN_VALUE){
             return dp[x][y];
         }
         
         
         
          int x1= calculateMinimumHP(dungeon,dp,x,y+1);
          int y1= calculateMinimumHP(dungeon,dp,x+1,y);
         
          int max=Math.min(x1,y1);
         
          dp[x][y]=max-dungeon[x][y];      
          dp[x][y]= Math.max(1,dp[x][y]);
           return dp[x][y];
         
    }
}