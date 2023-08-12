package AdvanceDSA.LL;

import java.util.Scanner;

public class P3_ReverseLL {
    public static ListNode reverseList(ListNode A) {
        ListNode P=null;
        ListNode C=A;
        while (C!=null){
            ListNode T=C.next;
            C.next=P;
            P=C;
            C=T;
        }
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
        print_ll(head);
        ListNode revhead=reverseList(head);
        print_ll(revhead);
        print_ll(head);

    }
}
