package may20;
import java.util.*;
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


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> queue=new PriorityQueue<>(k,(a,b)->{
            if(a.val>b.val){
                return -1;
            }
            else{
                return 1;
            }
                
        });
        add(queue,root,k);
        return queue.poll().val;
    }
    
    private void add(PriorityQueue<TreeNode> queue,TreeNode node,int k){
               if(node==null)
                   return;
        addToQueue(queue,node,k);
        add(queue,node.left,k);
        add(queue,node.right,k);
    } 
    
    
    private void addToQueue(PriorityQueue<TreeNode> queue,TreeNode node,int k){
        
        if(queue.size()<k){
            queue.add(node);
        }
        else{
            if(node.val<queue.peek().val){
                 queue.poll();
               queue.add(node); 
            }
        }
            
      
    }
}