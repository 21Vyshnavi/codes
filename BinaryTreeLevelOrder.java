import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // number of elements
        int arr[] = new int[n];

        // Input array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Edge case
        if (n == 0) return;

        // Create root
        Node root = new Node(arr[0]);

        // Queue for level order construction
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        // Build tree
        while (i < n) {
            Node t = q.poll();

            // Left child
            if (i < n && arr[i] != -1) {
                t.left = new Node(arr[i]);
                q.offer(t.left);
            }
            i++;

            // Right child
            if (i < n && arr[i] != -1) {
                t.right = new Node(arr[i]);
                q.offer(t.right);
            }
            i++;
        }

        // Inorder Traversal
        inorder(root);
    }

    // Inorder Traversal: Left -> Root -> Right
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");  // FIXED (print instead of println)
        inorder(root.right);
    }
}

// Node class
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}
