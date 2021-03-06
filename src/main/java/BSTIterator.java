import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Complexity : O(1) time Average for next() , O(1) time for hasNext() , O(h memory)
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        if(root!=null) stack.push(root);
        while(node!=null && node.left!=null){
            stack.push(node.left);
            node=node.left;
        }

    }

    /** @return the next smallest number */
    public int next(){

        TreeNode node = stack.pop();
        if(node.right!=null){
            stack.push(node.right);
            TreeNode node1=node.right;
            while(node1!=null && node1.left!=null){
                stack.push(node1.left);
                node1=node1.left;
            }
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */