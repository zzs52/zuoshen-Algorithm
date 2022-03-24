二叉树的宽度优先遍历
```text
public static void w(Node head) {
    if(head == null) {
        return;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(head);
    while(!queue.isEmpty()) {
        Node cur = queue.poll();
        System.out.print(cur.value + " ");
        if (cur.left != null) {
            queue.add(cur.left);
        }
        if (cur.right != null) {
            queue.add(cur.right);
        }
    }
}
```