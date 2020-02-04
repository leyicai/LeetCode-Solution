import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// BFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    res.append("null,");
                    continue;
                }
                res.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        res.deleteCharAt(res.length() - 1); // remove the last comma
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null"))
            return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        TreeNode curr = root;
        Queue<TreeNode> q = new LinkedList<>();
        boolean isLeft = true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode node = null;
            if (!nodes[i].equals("null")) {
                node = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(node);
            }
            if (isLeft) {
                curr.left = node;
            } else {
                curr.right = node;
                curr = q.poll();
            }
            isLeft = !isLeft;
        }
        return root;
    }
}

// DFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder res = new StringBuilder();
        serializeHelper(root, res);
        return res.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder res) {
        if (node == null) {
            res.append("null,");
        } else {
            res.append(node.val).append(",");
            serializeHelper(node.left, res);
            serializeHelper(node.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null"))
            return null;
        String[] nodes = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> q) {
        if (q.isEmpty())
            return null;
        String val = q.poll();
        if (val.equals("null")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = deserializeHelper(q);
            root.right = deserializeHelper(q);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
