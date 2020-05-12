class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
         int oldColor=image[sr][sc];
        //base case :if both colors are same no need to traverse matrix
        
        if(oldColor==newColor)
            return image;
       return floodFill(image,sr,sc,oldColor,newColor);
        
    }
    
     public int[][] floodFill(int[][] image, int sr, int sc, int oldColor,int newColor) {
        // Bas case: boundry conditions
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[sr].length)
            return image;
       
        if(image[sr][sc]==oldColor){
            image[sr][sc]=newColor;
            floodFill(image, sr,sc-1,oldColor,newColor);
            floodFill(image, sr,sc+1,oldColor,newColor);
            floodFill(image, sr-1,sc,oldColor,newColor);
            floodFill(image, sr+1,sc,oldColor,newColor);
        }
        return image;
        
    }
}
