package CodeInterview;

public class Chap2_5 {
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

    static Node sumList(Node n1, Node n2, int carryover) {
        if(n1 == null && n2 == null && carryover == 0) {
            return null;
        }

        int value = 0;

        if(n1 != null) {
            value += n1.value;
        }

        if(n2 != null) {
            value += n2.value;
        }

        value += carryover;

        Node newNode = new Node(value % 10);

        Node nextNode = sumList((n1 != null) ? n1.next : null, (n2 != null) ? n2.next : null, (value >= 10) ? 1 : 0);

        newNode.next = nextNode;
        return newNode;
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.appendToTail(1);

        Node head2 = new Node(5);
        head2.appendToTail(9);
        head2.appendToTail(5);

        sumList(head1,head2,0).print();
    }
}
