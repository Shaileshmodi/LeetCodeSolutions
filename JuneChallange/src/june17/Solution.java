package june17;

class Solution {
    public void solve(char[][] board) {
        // handle empty matrix
        if(board.length==0)
            return;
        //First replace all 'O' with '_'
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='_';
                }        
            }
        }
        
        //Start filling O from border recursively
        for(int j=0;j<board[0].length;j++){
            fill(board,0,j);
        }
        for(int j=0;j<board[0].length;j++){
            fill(board,board.length-1,j);
        }
          for(int i=0;i<board.length;i++){
            fill(board,i,0);
        }
          for(int i=0;i<board.length;i++){
            fill(board,i,board[i].length-1);
        }
        
        //ultimately replace all _ with 'X'
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='_'){
                    board[i][j]='X';
                }        
            }
        }
        
        
        
    }
    
    
    
    private void fill(char[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[i].length)
            return;
        
        if(board[i][j]!='_')
            return;
        
        int[] x={0,-1,0,1};
        int[] y={-1,0,1,0};
        board[i][j]='O';
        for(int k=0;k<x.length;k++){
            int newX=i+x[k];
            int newY=j+y[k];
            fill(board,newX,newY);  
        }
        
        
    }
}