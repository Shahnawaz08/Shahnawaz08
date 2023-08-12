package AdvanceDSA.LL;
/*
Given a singly linked list, delete middle of the linked list.

For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.

For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

Return the head of the linked list after removing the middle node.

If the input linked list has 1 node, then this node should be deleted and a null node should be returned.
 */


import java.util.Scanner;

class Node {
      public int val;
      public Node next;
      Node(int x) { val = x; next = null; }
 }
public class P1_DeleteMiddleNodeOfALinkedList {
    public static Node solve(Node A) {
        if(A==null|| A.next==null){
            return null;
        }
        //finding the middle index
        int mid=lengthLL(A)/2;
        Node temp=A;
        int i=1;
        while (i<mid){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return A;

    }
    public static int lengthLL(Node head){
        Node temp=head;
        int len=0;
        while (temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }

    public static Node createLL(int n){
        Node head=new Node(1);
        Node tail=head;
        for(int d=2;d<=n;d++){
            tail.next=new Node(d);
            tail=tail.next;
        }
        return head;
    }
    public static void print_ll(Node head) {
        // Output each element followed by a space
        Node start=head;
        while (start!=null){
            System.out.print(start.val+" ");
            start=start.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of LinkedList ");
        int n=sc.nextInt();
        Node head=createLL(n);
        print_ll(head);
        System.out.println(lengthLL(head));
        Node head1=solve(head);
        print_ll(head);
        print_ll(head1);
    }
}
