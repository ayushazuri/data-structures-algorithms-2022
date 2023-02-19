import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZag {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int i) {
            this.val = i;
            this.left = this.right = null;
        }

        public Node(int i, Node left, Node right) {
            this.val = i;
            this.left = left;
            this.right = right;
        }
    }

    public Node generateBinaryTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        return root;
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        Node node = zigZag.generateBinaryTree();
        LinkedList<LinkedList<Integer>> result = zigZag.zigzagTraversal(node);
        result.forEach(System.out::println);

    }

    public LinkedList<LinkedList<Integer>> zigzagTraversal(Node node){
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean isLTR = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> rows = new LinkedList<>();
            while(size-- > 0){
                Node elem = queue.poll();
                if(elem.left != null) queue.add(elem.left);
                if(elem.right != null) queue.add(elem.right);

                if(isLTR){
                    rows.addLast(elem.val);
                } else {
                    rows.addFirst(elem.val);
                }
            }
            result.add(rows);
            isLTR = !isLTR;
        }
        return result;
    }
}
