package CodeInterview;

public class Chap2_2 {
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


    static Node kthToLast(Node head, int k) {
        Node current = head;
        Node runner = head;
        int runnerCounter = 0;

        while(runner.next != null && runnerCounter < k - 1) {
            runner = runner.next;
            runnerCounter++;
        }

        if(runner.next == null) {
            return head;
        }

        while(runner.next != null) {
            runner = runner.next;
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(2);
        list.add(6);
        list.add(1);
        list.display();
        System.out.println("kth to last is " + kthToLast(list.head, 0).data);
    }

}
