package AdvanceDSA.LL;

import java.util.Scanner;

public class P9_SortList {
    public static ListNode sortList(ListNode A) {
        if(A==null||A.next==null){
            return A;
        }
        int mid=lengthLL(A)/2;
        //System.out.println(mid);
        ListNode h1=A;
        int cnt=1;
        while (cnt<mid){
            A= A.next;
            cnt++;
        }
        ListNode h2= A.next;
        A.next=null;
//        print_ll(h1);
//        print_ll(h2);
        h1=sortList(h1);
        h2=sortList(h2);

        return mergeTwoLists(h1,h2);
//        return A;
    }
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
        ListNode A=createLL(n);

        print_ll(A);
        ListNode head=sortList(A);
        print_ll(head);





    }
}
