/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null || preorder.length==0)
            return null;
        
        TreeNode root= new TreeNode(preorder[0]);
        Stack<TreeNode> data=new Stack<>();
        data.push(root);
        
        addRemaining(data,preorder);
        
        
        
        return root;
    }
    
    
    private void addRemaining(Stack<TreeNode> stack,int[] preorder){
        for(int i=1;i<preorder.length;i++){
            int currentElement=preorder[i];
            
            if(!stack.isEmpty() && currentElement<stack.peek().val){
                TreeNode newNode=new TreeNode(currentElement);
                stack.peek().left=newNode;
                stack.push(newNode);
                continue;
            }
            
            TreeNode temp=null;
            while(!stack.isEmpty() && currentElement>stack.peek().val){
                temp=stack.pop();
            }
            
            if(temp!=null){
                TreeNode newNode=new TreeNode(currentElement);
                temp.right=newNode;
                stack.push(newNode);
            }
            
            
            
            
        }
        
        
        
        
        
        
    }
    
    
}