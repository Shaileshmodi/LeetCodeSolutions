package tree.inorder.traverse;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //inorderTraversalRecursive(root,list);
        // inorderTraversalUsingStack(root,list);
        inorderTraversalUsingMorris(root, list);
        return list;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorderTraversalRecursive(root.left, list);
        list.add(root.val);
        inorderTraversalRecursive(root.right, list);
    }

    private void inorderTraversalUsingStack(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
    }

    private void inorderTraversalUsingMorris(TreeNode root, List<Integer> list) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                list.add(current.val);
                current = current.right;
            } else {
                TreeNode left = current.left;
                while (left.right != null) {
                    left = left.right;//find rightmost node of left subtree
                }
                left.right = current;// Assign current,right to the above node
                TreeNode tmp = current;
                current = current.left;//Assign current as the left child
                tmp.left = null;//Now there is no use of left subtree of the last node because it is already expanded and we don't want duplicate node present
            }

        }

    }
}