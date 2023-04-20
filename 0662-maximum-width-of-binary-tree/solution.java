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
     public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>() ; 
        root.val = 1; 
        int max_width = 0 ; 
        int size = 1  ;
        q.add(root) ; 
        while(! q.isEmpty()){
            int next_size = 0 ;
            int s = -1 , e =-1 ; 
            while(size-->0){
                TreeNode node = q.poll() ; 
                
                if(s==-1) s = node.val;
                e = node.val ; 
                if(node.left != null){
                    node.left.val = 2*node.val ; 
                    q.add(node.left) ; 
                    next_size++ ; 
                }
                if(node.right != null){
                    node.right.val = 2*node.val+1 ;
                    q.add(node.right) ;
                    next_size++ ;
                }
            }
            max_width = Math.max(max_width , e-s+1 );
            size = next_size ; 
        }
        
        return max_width ; 

    }
}
