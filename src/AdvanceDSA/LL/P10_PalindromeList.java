package AdvanceDSA.LL;

import java.util.HashMap;
import java.util.Scanner;
/*
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.

Problem Constraints
1 <= |A| <= 105
 */

public class P10_PalindromeList {
    public static int lPalin(ListNode A) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        ListNode temp=A;
        int len=lenLL(A);
        int timesAdd=len/2;
        int idx=0;
        while (timesAdd--!=0){
            hm.put(idx, temp.val);
            temp=temp.next;
            idx++;
        }
        if(len%2==1){
            temp=temp.next;
            idx++;
        }
        System.out.println(hm);
        while (temp!=null){
            if(hm.get(len-1-idx)==temp.val){
                temp=temp.next;
                idx++;
            }
            else {
                System.out.println("val"+temp.val+" "+idx);
                return 0;
            }
        }


        return 1;
    }
    public static int lenLL(ListNode A){
        int len=0;

        while (A!=null){
            len++;
            A=A.next;
        }
        return len;
    }
    public static ListNode createLL(int n,Scanner sc){
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
        int ispalindrome=lPalin(head);
        System.out.println("is the given linked list is palindrome "+ispalindrome);
        //print_ll(head);



    }
}
