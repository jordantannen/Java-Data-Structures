class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}


public class BST {
    Node root; // root of BST

    BST() {
        root = null;
    }

    Node insertRec(Node root, int data) {
        // insert into tree
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) // insert left child
            root.left = insertRec(root.left, data);
        else if (data > root.data) // insert right child
            root.right = insertRec(root.right, data);

        return root;
    }

    // helper functions
    // call insertRec from main
    void insert(int data) {
        root = insertRec(root, data);
        System.out.println("New item inserted into tree => " +
                data);
    }

    // perform a postorder traversal
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.data);
        }
    }

    // Returns the max value in a binary tree
    static int findMax(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    // Returns the min value in a binary tree
    static int findMin(Node node){
        if (node == null)
            return Integer.MAX_VALUE;
        int min = node.data;
        int lres = findMin(node.left);
        int rres = findMin(node.right);
        if (lres < min)
            min = lres;
        if (rres < min)
            min = rres;
        return min;
    }

    // Preorder Traversal
    void preOrderTraversal(Node node)
    {
        if (node == null)
            return;
        System.out.println(node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // Inorder Traversal
    void inOrderTraversal(Node node){
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    // Removes record from tree
    Node removeRec(Node root, int num){
        if (root == null) {
            return root;
        }

        if (num < root.data)
            root.left = removeRec(root.left, num);
        else if (num > root.data)
            root.right = removeRec(root.right, num);
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            root.data = findMin(root.right);
            root.right = removeRec(root.right, root.data);
        }
        return root;
    }
    void delete(int num){
        if (!search(root, num))
            System.out.println(num + " not in tree");
        else{
            root = removeRec(root, num);
            System.out.println(num + " removed from tree");
        }
    }

    // Searches for record
    boolean search(Node node, int num){
        if (node == null) {
            return false;
        }
        if (node.data == num) {
            return true;
        }
        else if (node.data > num)
            return search(node.left, num);
        else
            return search(node.right, num);
    }

    void printSearch(Node node, int num){
        if (search(node, num))
            System.out.println(num + " was found in the tree");
        else
            System.out.println(num + " was not found in the tree");
    }

    // Prints the size of the tree
    int size(Node node){
        if (node == null)
            return 0;
        else
            return (size(node.left) + 1 + size(node.right));
    }

    public static void main(String[] args) {

        BST tree = new BST(); // create tree object
        /* Tree operations ************************/
        // build the tree
        // insert into tree
        tree.insert(27);
        tree.insert(13);
        tree.insert(42);
        tree.insert(6);
        tree.insert(17);
        tree.insert(33);
        tree.insert(48);
        // print max element of tree
        System.out.println("\nMaximum element is " +
                tree.findMax(tree.root));
        System.out.println("\nMinimum element is " +
                tree.findMin(tree.root));
        // print postorder of tree
        System.out.println("\nPostorder -> ");
        tree.postorderRec(tree.root);
        // print preorder of tree
        System.out.println("\nPreorder -> ");
        tree.preOrderTraversal(tree.root);
        // print inorder of tree
        System.out.println("\nInorder -> ");
        tree.inOrderTraversal(tree.root);

        // Print size
        System.out.println("\nTree size: " + tree.size(tree.root));
        System.out.println();

        // Remove from tree
        tree.delete(13);
//        tree.delete(7);
        System.out.println();

        // print inorder of tree
        System.out.println("\nInorder after removal -> ");
        tree.inOrderTraversal(tree.root);


        // Size after removal
        System.out.println("\nTree size: " + tree.size(tree.root));
        System.out.println();

        // testing search of tree
        tree.printSearch(tree.root, 6);
        System.out.println();
        tree.printSearch(tree.root, 13);
    }

}
