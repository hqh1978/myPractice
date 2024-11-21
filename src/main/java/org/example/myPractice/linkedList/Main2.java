package org.example.myPractice.linkedList;

public class Main2 {
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        node5.setNext(node1);  // Creates a cycle
        boolean circled = detectCycle(node1);
        System.out.println("circled is " + circled);
    }
    // 快慢指针检测环
    public static boolean detectCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node quick = head.next;

        while (quick != null && quick.next != null) {
            if (slow == quick) {
                return true; // 有环
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return false; // 无环
    }
}
