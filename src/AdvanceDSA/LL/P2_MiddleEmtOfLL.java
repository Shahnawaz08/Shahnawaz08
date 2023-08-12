package AdvanceDSA.LL;
/*
Given a linked list of integers, find and return the middle element of the linked list.

        NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.



        Problem Constraints
        1 <= length of the linked list <= 100000

        1 <= Node value <= 109

 */


import java.util.Scanner;
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }


}

public class P2_MiddleEmtOfLL {
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
    public static int solve(ListNode A) {
        if(A==null){
            return 0;
        }
        //finding the middle index
        int mid=lengthLL(A)/2;
        ListNode temp=A;
        int i=0;
        while (i<mid){
            temp=temp.next;
            i++;
        }
        return temp.val;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of linked list");
        int n=sc.nextInt();
        ListNode head=createLL(n);
        System.out.println(solve(head));


    }
}
