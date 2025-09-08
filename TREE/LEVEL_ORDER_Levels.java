package TREE;

import java.util.ArrayList;
import java.util.Queue;

public class LEVEL_ORDER_Levels {
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
    public void LevelOrder(TreeNode root){
        if(root == null) return;
        Queue<Integer> queue = new ArrayList();
        queue.add(root.val);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size;i++){
              TreeNode current = queue.poll();
              System.out.print(current.val + " ");
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);  
            }
        }
    }
    public static void main(String[] args) {
        LEVEL_ORDER_Levels tree = new LEVEL_ORDER_Levels();
        TreeNode root = tree.new TreeNode(1);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(3);
        tree.LevelOrder(root);
    }
}
