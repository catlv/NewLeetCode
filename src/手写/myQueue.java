package 手写;

import java.util.Queue;

public class myQueue {
    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    volatile Node head;
    volatile Node tail;

    public myQueue() {
        head = tail = new Node(0);
    }

    public myQueue(Queue<Integer> c) {
        Node h = null;
        Node t = null;
        for (int e : c) {
            Node newNode = new Node(e);
            if (h == null) {
                h = t = newNode;
            } else {
                t.next = newNode;
                t = newNode;
            }
        }
        if (h == null) {
            h = t = new Node(0);
        }
        head = h;
        tail = t;
    }

    public boolean CAS(Node curV, Node oldV, Node newV) {
        if (curV == oldV) {
            curV = newV;
            return true;
        }
        return false;
    }

    public boolean add(int e) {
        Node n = new Node(e);
        n.next = null;
        Node p = tail;
        Node oldP = p;
        while (!CAS(p.next, null, n)) {
            while (p.next != null) {
                p = p.next;
            }
        }
        CAS(tail, oldP, n);
        return true;
    }

//    public boolean add(int e) {
//        Node n = new Node(e);
//        n.next = null;
//        Node tailTemp;
//        Node nextTemp;
//        while (true) {
//            tailTemp = tail;
//            nextTemp = tail.next;
//
//            if (tailTemp != tail) {
//                continue;
//            }
//            if (nextTemp != null) {
//                CAS(tail, tailTemp, nextTemp);
//                continue;
//            }
//            if (CAS(tailTemp.next, nextTemp, n)) {
//                break;
//            }
//        }
//        CAS(tail, tailTemp, n);
//        return true;
//    }
}
