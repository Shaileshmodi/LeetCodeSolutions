package tree;



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class DepthData{
    int xDepth=0;
    int yDepth=0;
    int x;
    int y;
}
class CheckCousins {
    public  boolean isCousins(TreeNode root, int x, int y) {
        DepthData data = new DepthData();
        data.x=x;
        data.y=y;
        boolean result=isCousins(root, data, 0);
        return result && data.xDepth==data.yDepth;
    }




    private boolean isCousins(TreeNode root, DepthData data, int depth){
        if(root == null){
            return true;
        }

        if(root.val == data.x){
            data.xDepth = depth;
        }


        if(root.val == data.y){
            data.yDepth = depth;
        }

        if(root.left!=null && root.right!=null && (root.left.val==data.x && root.right.val==data.y || root.left.val==data.y && root.right.val==data.x)){

            return false;
        }

        if(!isCousins(root.left,data, depth+1))
            return false;
        if(!isCousins(root.right,data, depth+1))
            return false;

        return true;
    }
}