package solutions.pack10_BST;

public class TreeNode_660859 {
    int data;
    TreeNode_660859 left, right, parent;
    
    public TreeNode_660859(int d) {
        data = d;
        left = null;
        right = null;
        parent = null;
    }
    
    @Override
    public String toString() {
        // There are 4 cases
        // no child,
        // left-child-only,
        // right-child-only,
        // and both children
        /* your code */
        if (left != null && right != null) {
            return left.data + " <- " + data + " -> " + right.data;
        } else if (left != null && right == null) {
            return left.data + " <- " + data + " -> null";
        } else if (left == null && right != null) {
            return "null <- " + data + " -> " + right.data;
        } else {
            return "null<-" + data + "->null";
        }
    }  
}
