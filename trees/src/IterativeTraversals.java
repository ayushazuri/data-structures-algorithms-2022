import java.util.Stack;

public class IterativeTraversals {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int i) {
            this.val = i;
            this.left = this.right = null;
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

    Stack<Node> stack = new Stack<>();
    public void iterativePreOrder(Node tree){
        if(tree == null)
            return;
        stack.clear();
        stack.push(tree);

        while(!stack.isEmpty()){
            Node elem = stack.pop();
            System.out.print(elem.val + " ");
            if(elem.right != null)
                stack.push(elem.right);
            if(elem.left != null)
                stack.push(elem.left);
        }
    }

    public void iterativeInOrder(Node tree) {
        stack.clear();
        Node curr = tree;

        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                Node elem = stack.pop();
                System.out.print(elem.val + " ");
                curr = elem.right;
            }
        }
    }

    public void iterativePostOrderFirst(Node tree){
        if(tree == null) return;

        stack.clear();
        Stack<Node> stack1 = stack;
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(tree);
        while(!stack1.isEmpty()){
            Node elem = stack1.pop();
            stack2.push(elem.val);
            if(elem.left != null)
                stack1.push(elem.left);
            if (elem.right != null)
                stack1.push(elem.right);
        }

        while(!stack2.isEmpty()){
            System.out.print(stack2.pop() + " ");
        }
    }

    public static void main(String[] args) {
        IterativeTraversals iterativeTraversals = new IterativeTraversals();
        Node tree = iterativeTraversals.generateBinaryTree();

        System.out.println("Iterative preorder traversal");
        iterativeTraversals.iterativePreOrder(tree);
        System.out.println();

        System.out.println("Iterative inorder traversal");
        iterativeTraversals.iterativeInOrder(tree);
        System.out.println();

        System.out.println("Iterative postorder traversal");
        iterativeTraversals.iterativePostOrderFirst(tree);
        System.out.println();
    }
}
