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
    long MOD = 1_000_000_007;
    long answer=0;
    public long dfs(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        long left=dfs(root.left);
        long right=dfs(root.right);
        root.val+=left+right;
        return root.val;
    }
    public int maxProduct(TreeNode root)
    {
        long total=dfs(root);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            long prod=node.val*(total-node.val);
            answer=Math.max(answer,prod);
            if(node.left!=null)
            {
                queue.add(node.left);
            }
            if(node.right!=null)
            {
                queue.add(node.right);
            }
        } 
        return (int)(answer%MOD);
    }
}