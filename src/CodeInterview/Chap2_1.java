package CodeInterview;

public class Chap2_1 {
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static class LinkedList {
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

    static void removeDup(LinkedList list) {
        Node current = list.head;

        while(current.next != null) {
            Node runner = current;
            while(runner.next != null) {
                if(current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(5);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(1);

        list.display();

        removeDup(list);

        list.display();
    }
}
