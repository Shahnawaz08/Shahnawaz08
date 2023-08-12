package AdvanceDSA.LL;
/*
Given a linked list A and a value B, partition it such that
all nodes less than B come before nodes greater than or equal to B.
You should preserve the original relative order of the nodes in each
of the two partitions.

Problem Constraints
1 <= |A| <= 106

1 <= A[i], B <= 109
 */

import java.util.Scanner;

public class P11_PartitionList {
    public static ListNode partition(ListNode A, int B) {
        ListNode newHead=new ListNode(B-1);
        newHead.next=A;
        ListNode head=newHead;
        ListNode tail=newHead;
        while (head.next!=null&&head.next.val<B){
            head=head.next;
            tail=tail.next;
        }
        while (tail.next!=null){
            if(tail.next.val>=B){
                tail=tail.next;
            }
            else {
                ListNode temp=tail.next;
                tail.next=temp.next;
                ListNode T=head.next;
                head.next=temp;
                temp.next=T;
                head=head.next;
            }
        }
        return newHead.next;
    }
    public static ListNode createLL(int n, Scanner sc){
        int x=sc.nextInt();
        ListNode head=new ListNode(x);
        ListNode tail=head;
        for(int d=2;d<=n;d++){
            x=sc.nextInt();
            tail.next=new ListNode(x);
            tail=tail.next;
        }
        return head;
    }
    public static void print_ll(ListNode head) {
        // Output each element followed by a space
        ListNode start=head;
        while (start!=null){
            System.out.print(start.val+"--->");
            start=start.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of LinkedList ");
        int n=sc.nextInt();
        ListNode head=createLL(n,sc);
        System.out.println("Enter value of partition ");
        int B=sc.nextInt();
        ListNode newhead=partition(head,B);
        print_ll(newhead);
        //print_ll(head);



    }
}
