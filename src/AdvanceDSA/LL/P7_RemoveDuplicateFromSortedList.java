package AdvanceDSA.LL;
/*
Given a sorted linked list, delete all duplicates such that each element appears only once.
Problem Constraints
0 <= length of linked list <= 106

 */

import java.util.Scanner;

public class P7_RemoveDuplicateFromSortedList {
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode temp=A;
        while (temp!=null){
            while (temp.next!=null && temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        return A;
    }
    public static int lengthLL(ListNode head){
        ListNode temp=head;
        int len=0;
        while (temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
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
            System.out.print(start.val+"--->");
            start=start.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of LinkedList ");
        int n=sc.nextInt();
        ListNode head=createLL(n);
        System.out.println(" Enter positions from where to where u want to reverse ");
        int B=sc.nextInt();
        print_ll(head);
        ListNode h=deleteDuplicates(head);
        print_ll(h);



    }
}
