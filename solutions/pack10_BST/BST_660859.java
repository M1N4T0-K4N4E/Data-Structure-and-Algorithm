package solutions.pack10_BST;

import java.util.ArrayList;
import java.util.Stack;

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
                    TreeNode_660859 prevTmp2 = tmp;
                    TreeNode_660859 tmp2 = tmp.left;
                    TreeNode_660859 maxLeft = tmp2;
                    while (tmp2.right != null) {
                        maxLeft = tmp2;
                        prevTmp2 = tmp2;
                        tmp2 = tmp2.right;
                    }
                    // delete
                    tmp.data = maxLeft.data;
                    if (maxLeft.left != null) {
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
        return heightRecurse(root);
    }

<<<<<<< HEAD
    public int heightRecurse(TreeNode_660859 node) {
        if (node == null) return 0;
        return Math.max(heightRecurse(node.left) + 1, heightRecurse(node.right) + 1);
=======
    private int heightRecurse(TreeNode_660859 node) {
        return 1 + Math.max(node.left == null ? 0 : heightRecurse(node.left),
                        node.right == null ? 0 : heightRecurse(node.right));
>>>>>>> 09e1f91291f0e11b368704e522ea97ab89d7b50f
    }

    public int count() {
        return nodeCountingRecurse(root);
    }

    private int nodeCountingRecurse(TreeNode_660859 node) {
        return (node.left == null ? 0 : nodeCountingRecurse(node.left))
               + (node.right == null ? 0 : nodeCountingRecurse(node.right)) + 1;
    }

    public long findMedian() {
        if (root == null) return 0;
        TreeNode_660859 tmp = root;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        traverseToArray(arr, root);
        arr.sort(Integer::compareTo);
        long median = 0;
        if (arr.size() % 2 == 0) {
            median = (arr.get(arr.size() / 2) + arr.get((arr.size() / 2) - 1)) / 2;
        } else {
            median = arr.get(arr.size() / 2);
        }
        return median;
    }

    public int findRank(int d) {
        if (root == null) return -1;
        ArrayList<Integer> arr = new ArrayList<>();
        traverseToArray(arr, root);
        arr.sort(Integer::compareTo);
        return !arr.contains(d) ? -1 : arr.indexOf(d) + 1;
    }

    private void traverseToArray(ArrayList<Integer> arr, TreeNode_660859 node) {
        arr.add(node.data);
        if (node.left != null) traverseToArray(arr, node.left);
        if (node.right != null) traverseToArray(arr, node.right);
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