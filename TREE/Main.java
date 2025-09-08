import java.util.ArrayList;

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
    public void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(p, list1);
        inorder(q, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        // Tree 1:      1
        //            /   \
        //           2     3
        TreeNode tree1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        // Tree 2:      1
        //            /   \
        //           2     3
        TreeNode tree2 = new TreeNode(1, new TreeNode(1), new TreeNode(3));

        Solution sol = new Solution();
        boolean result = sol.isSameTree(tree1, tree2);
        System.out.println("Are the two trees the same? " + result);
    }
}
