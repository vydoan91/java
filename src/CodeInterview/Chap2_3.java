package CodeInterview;

public class Chap2_3 {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
        Node head;
        LinkedList() {
            head = null;
        }

        void add(int data) {
            if(head == null) {
                head = new Node(data);
                return;
            }
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }

        void display() {
            Node current = head;
            while(current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("\n");
        }
    }

    static void deleteMiddleNode(LinkedList list) {
        Node current = list.head;
        Node runner = list.head;
        Node prev = null;

        if(current.next == null || current.next.next == null) {
            return;
        }

        while(runner.next != null && runner.next.next != null) {
            prev = current;
            current = current.next;
            runner = runner.next.next;
        }
        prev.next = current.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(9);
//        list.add(2);
//        list.add(6);
//        list.add(1);
//        list.add(1);
        list.display();
        deleteMiddleNode(list);
        list.display();
    }
}
