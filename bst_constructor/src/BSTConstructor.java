import java.util.Arrays;

public class BSTConstructor {
    private Node root;

    public BSTConstructor(double [] list){
        sort_list(list); // Sort the list
        this.root = orderBST(list, 0, list.length-1);
    }

    private Node orderBST(double list[], int l, int r){
        // Breakpoint
        if (l>r) return null;

        // Index of value we want to insert into the node we create
        int middle = find_center_value(l, r);

        // The new node
        Node node = new Node(list[middle]);

        // Left side of root
        node.left = orderBST(list, l, middle-1);

        // Right side of root
        node.right = orderBST(list, middle+1, r);

        return node;
    }

    public void printNodes(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printNodes(node.left);
        printNodes(node.right);
    }

    private int find_center_value(int index_1, int index_2){
        int mid = index_2+index_1;
        return (int) Math.floor(mid/2);
    }

    private void sort_list(double [] list){
        Arrays.sort(list);
    }

    public static void main(String [] args){
        double [] list = {1.23, 42.4, 54.4, 32.2, 54.7, 78.4, 2.43, 14.32, 3.32, 4.32};
        BSTConstructor bst = new BSTConstructor(list);
        bst.printNodes(bst.root);

    }



}
