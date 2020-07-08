package tree.symmetrictrees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
       // return areMirrorRec(root.left,root.right);
         return areMirrorItr(root.left,root.right);
    }
    
    private boolean areMirrorRec(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
        
       return node1.val==node2.val 
           && areMirrorRec(node1.left,node2.right) 
           && areMirrorRec(node1.right,node2.left);     
    }
     
    
    private boolean areMirrorItr(TreeNode node1,TreeNode node2){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node1);
        queue.add(node2);
        while(!queue.isEmpty()){
            TreeNode element1=queue.poll();
            TreeNode element2=queue.poll();
            if(element1==null && element2==null)
                continue;
            if(element1==null || element2==null){
                return false;
            }
            if(element1.val!=element2.val)
                return false;
              queue.add(element1.left);
              queue.add(element2.right);
              queue.add(element2.left);
              queue.add(element1.right);
            
        }
        return true;
        
    }
    
    
}