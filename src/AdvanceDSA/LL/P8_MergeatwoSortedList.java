package AdvanceDSA.LL;

import java.util.List;
import java.util.Scanner;
/*
Merge two sorted linked lists, A and B, and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists and should also be sorted.

Problem Constraints
0 <= |A|, |B| <= 105
 */

public class P8_MergeatwoSortedList {
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A==null&&B==null){
            return null;
        }
        if(B==null){
            return A;
        }
        if(A==null){
            return B;
        }
        ListNode temp=null;
        if(A.val< B.val){
            temp=A;
            temp.next=mergeTwoLists(A.next,B);
        }else {
            temp=B;
            temp.next=mergeTwoLists(A,B.next);
        }
        return temp;
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
        ListNode A=createLL(n);
        System.out.println("Enter size of a second LinkedList");
        int m=sc.nextInt();
        ListNode B=createLL(m);
        print_ll(A);
        print_ll(B);
        ListNode head=mergeTwoLists(A,B);
        print_ll(head);




    }
}
