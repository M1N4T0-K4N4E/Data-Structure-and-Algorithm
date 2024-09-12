package solutions.pack10_BST;

public class BST {
    TreeNode root;
    
    public BST() { root = null; }
    
    public TreeNode getRoot() {
        return root;
    }
    
    /* your code here */
    public void insert(int d) {

    }

    public TreeNode search(int d) {

    }

    public void delete(int d) {

    }

    /* Printing */
    void printPostOrder(TreeNode node) {
        if(node==null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.data+" ");
    }

    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }
    
    private void printInOrderRecurse(TreeNode node) {
        if (node == null) return ;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }

    void printPreOrder(TreeNode node) {
        if(node==null) return;
        System.out.println(node.data+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}