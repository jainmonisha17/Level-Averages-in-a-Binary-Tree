import java.util.*;

public class levelAveragesOfBinaryTree {

static class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;

 TreeNode(int x) {
         val = x;
     }
 }

  public  List<Double> findLevelAverages(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      double levelSum = 0;
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        // add the node's value to the running sum
        levelSum += currentNode.val;
        // insert the children of current node to the queue
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
      // append the current level's average to the result array
      result.add(levelSum / levelSize);
    }

    return result;
  }

  public static void main(String[] args) {
    levelAveragesOfBinaryTree sol = new levelAveragesOfBinaryTree();
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = sol.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}

// Time Complexity
// The time complexity of the above algorithm is , where  is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

// Space Complexity
// The space complexity of the above algorithm will be  which is required for the queue. Since we can have a maximum of  nodes at any level (this could happen only at the lowest level), therefore we will need  space to store them in the queue.