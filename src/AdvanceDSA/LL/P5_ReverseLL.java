package AdvanceDSA.LL;
/*
Reverse a linked list A from position B to C.
NOTE: Do it in-place and in one-pass.

Problem Constraints
1 <= |A| <= 106
1 <= B <= C <= |A|
 */

import java.util.Scanner;

public class P5_ReverseLL {
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode temp=null;
        ListNode futtail=null;
        ListNode P=null;
        ListNode Cr=null;
        int cnt=1;
        if(B>1) {
            temp=A;
            while (cnt < B - 1) {
                temp = temp.next;
                cnt++;
            }
            futtail=temp.next;
            P=temp.next;
            Cr=P.next;
        }
        else {
            futtail = A;
            P = A;
            Cr = P.next;
        }
        cnt=1;
        int t=C-B;
        while (cnt<=t){
            ListNode T=Cr.next;
            Cr.next=P;
            P=Cr;
            Cr=T;
            cnt++;
        }

        futtail.next=Cr;
        if(temp!=null) {
            temp.next = P;
        }else {
            return P;
        }
        return A;
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
        System.out.println(" Enter positions from where to where u want to reverse ");
        int B=sc.nextInt();
        int C=sc.nextInt();
        print_ll(head);
        ListNode h=reverseBetween(head,B,C);
        print_ll(h);


    }
}
