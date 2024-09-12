package solutions.pack10_BST;

public class BST_660859 {
    TreeNode_660859 root;
    
    public BST_660859() { 
        root = null; 
    }
    
    public TreeNode_660859 getRoot() {
        return root;
    }
    
    /* your code here */
    public void insert(int d) {
        if (root == null) {
            root = new TreeNode_660859(d);
            return;
        }

        TreeNode_660859 tmp = root;
        TreeNode_660859 parent = null;
        while (tmp != null) {
            parent = tmp;
            if (d < tmp.data) {
                tmp = tmp.left;
                if (tmp == null) {
                    parent.left = new TreeNode_660859(d);
                    parent.left.parent = parent;
                    break;
                }
            } else if (d > tmp.data) {
                tmp = tmp.right;
                if (tmp == null) {
                    parent.right = new TreeNode_660859(d);
                    parent.right.parent = parent;
                    break;
                }
            }
        }
    }
    

    public TreeNode_660859 search(int d) {
        TreeNode_660859 tmp = root;
        while (tmp != null) {
            if (tmp.data == d) return tmp;
            else if (d < tmp.data) tmp = tmp.left;
            else if (d >= tmp.data) tmp = tmp.right;
        }
        return null;
    }

    public void delete(int d) {
        TreeNode_660859 tmp = root;
        TreeNode_660859 prev = null;
        while (tmp != null) {
            if (tmp.data == d) { // found
                if (tmp.left != null && tmp.right != null) { // 2 child
                    // find max left
                    TreeNode_660859 maxLeft = null;
                    TreeNode_660859 tmp2 = tmp.left;
                    TreeNode_660859 prevTmp2 = tmp;
                    while (tmp2 != null) {
                        maxLeft = tmp2;
                        prevTmp2 = tmp2;
                        tmp2 = tmp2.right;
                    }
                    // delete
                    tmp.data = maxLeft.data;
                    if (prevTmp2.right == null) {
                        prevTmp2.left = prevTmp2.left.left;
                    } else {
                        prevTmp2.right = null;
                    }
                } else if (tmp.left != null) { // 1 child left
                    prev.left = tmp.left;
                } else if (tmp.right != null) { // 1 child right
                    prev.right = tmp.right;
                } else { // no child
                    if (prev.left.data == d) prev.left = null;
                    else if (prev.right.data == d) prev.right = null;
                }
                break;
            }
            
            prev = tmp;
            if (d < tmp.data) {
                tmp = tmp.left;
            }
            else if (d > tmp.data) { 
                tmp = tmp.right;
            }
        }
    }

    public TreeNode_660859 findMax() {
        if (root == null) return null;
        
        TreeNode_660859 curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
    
    public TreeNode_660859 findMin() {
        if (root == null) return null;

        TreeNode_660859 curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public int height() {
        return 0;
    }

    public int count() {
        return nodeCountingRecurse(root);
    }

    private int nodeCountingRecurse(TreeNode_660859 node) {
        return (node.left == null ? 0 : nodeCountingRecurse(node.left))
               + (node.right == null ? 0 : nodeCountingRecurse(node.right)) + 1;
    }

    /* Printing */
    public void printPostOrder() {
        printPostOrderRecurse(root);
        System.out.println();
    }

    private void printPostOrderRecurse(TreeNode_660859 node) {
        if(node==null) return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.print(node.data+" ");
    }

    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }
    
    private void printInOrderRecurse(TreeNode_660859 node) {
        if (node == null) return ;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
        System.out.println();
    }

    private void printPreOrderRecurse(TreeNode_660859 node) {
        if(node==null) return;
        System.out.print(node.data+" ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }
}