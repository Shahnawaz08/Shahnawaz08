package AdvanceDSA.LL;

import java.util.Scanner;
/*
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time
and return the modified linked list.

Problem Constraints
1 <= |A| <= 103

B always divides A
 */

public class P4_KreverseLL {
    public static ListNode reverseList(ListNode A, int B) {
        if(A==null){
            return null;
        }
        ListNode P=A;
        ListNode C=A.next;
        int cnt=1;
        while (cnt<B){
            ListNode T=C.next;
            C.next=P;
            P=C;
            C=T;
            cnt++;
        }
        A.next=reverseList(C,B);
        return P;
    }
    public static ListNode createLL(int n){
        ListNode head=new ListNode(1);
        ListNode tail=head;
        for(int d=2;d<=n;d++){
            tail.next=new ListNode(d);
            tail=tail.next;
        }
        return head;
    }
    public static void print_ll(ListNode head) {
        // Output each element followed by a space
        ListNode start=head;
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
        ListNode head=createLL(n);
        System.out.println("size of list ");
        int B=sc.nextInt();
        print_ll(head);
        ListNode h=reverseList(head,B);
        print_ll(h);


    }
}
