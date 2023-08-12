package AdvanceDSA.LL;
/*
Given a linked list A, remove the B-th node from the end of the list and return its head.
For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end,
the linked list becomes 1->2->3->5.
NOTE: If B is greater than the size of the list, remove the first node of the list.
NOTE: Try doing it using constant additional space.



Problem Constraints
1 <= |A| <= 106
 */

import java.util.Scanner;

public class P6_RemoveNthNodeFromLidtEnd {
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int len=lengthLL(A);
        System.out.println(len);
        int N=len-B;
        if(N<=0){
            A=A.next;
            return A;
        }else {
            int cnt=1;
            ListNode temp=A;
            while (cnt<N){
                temp=temp.next;
                cnt++;
            }
            temp.next=temp.next.next;
        }
        return  A;

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
        ListNode h=removeNthFromEnd(head,B);
        print_ll(h);



    }
}
