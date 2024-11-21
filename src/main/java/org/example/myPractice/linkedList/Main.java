package org.example.myPractice.linkedList;

import org.checkerframework.checker.units.qual.N;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Node node5=new Node(5,null);
        Node node4=new Node(4,node5);
        Node node3=new Node(3,node4);
        Node node2=new Node(2,node3);
        Node node1=new Node(1,node2);
        node5.setNext(node1);

//        LinkedList<Node> linkedList=new LinkedList<>();
//        linkedList.add(node1);
//        linkedList.add(node2);
//        linkedList.add(node3);
//        linkedList.add(node4);
//        linkedList.add(node5);

        boolean circled=false;
        Node slow = node1;
        Node quick = node1.next;
        if (node1 == null || node1.next == null) {
            circled =false;
        }
        while (quick != null && quick.next != null) {
            if (slow == quick) {
                circled =true;
            }
            slow = slow.next;
            quick = quick.next.next;
        }

        System.out.println("circled is "+circled);
    }
}
