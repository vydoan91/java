package CodeInterview;

public class Chap2_4 {
    static class Node {
        int value;
        Node next = null;
        Node(int value) {
            this.value = value;
        }

        void appendToTail(int value) {
            Node end = new Node(value);
            Node n = this;
            while(n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
        Node delete(int value) {
            Node n = this;
            // search for the node
            while(n.next != null && n.value != value) {
                n = n.next;
            }
            if(n.next != null) {
                n.value = n.next.value;
                n.next = n.next.next;
            }
            return this;
        }
        void print() {
            Node n = this;
            while(n != null) {
                System.out.print(n.value + " ");
                n = n.next;
            }
            System.out.println();
        }
    }

    static Node partition(Node n, int x) {
        Node head = n;
        Node tail = n;
        Node next = null;

        while(n != null) {
            next = n.next;
            if(n.value < x) {
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(5);
        head.appendToTail(10);
        head.appendToTail(2);
        head.appendToTail(1);
        head.print();
        (head.delete(3)).print();

    }
}
