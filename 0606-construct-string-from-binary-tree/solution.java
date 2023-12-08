public class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        
        String result = root.val + "";
        
        String leftSubtree = tree2str(root.left);
        String rightSubtree = tree2str(root.right);
        
        if (leftSubtree.equals("") && rightSubtree.equals("")) {
            return result;
        }
        if (leftSubtree.equals("")) {
            return result + "()" + "(" + rightSubtree + ")";
        }
        if (rightSubtree.equals("")) {
            return result + "(" + leftSubtree + ")";
        }
        
        
        return result + "(" + leftSubtree + ")" + "(" + rightSubtree + ")";
    }
}
