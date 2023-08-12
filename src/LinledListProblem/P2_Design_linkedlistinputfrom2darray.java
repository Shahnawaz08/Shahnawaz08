package LinledListProblem;

import java.util.Scanner;

public class P2_Design_linkedlistinputfrom2darray {
    static Node head=null;
    static int len=0;
    public static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
            next=null;
        }

    }
    public static void insert_first(int val){
        Node temp=new Node(val);
        temp.next=head;
        head=temp;
        len++;

    }
    public static void insert_last(int val){
        Node temp=new Node(val);
        if(head==null){
            head=temp;
            len++;
            return;
        }
        Node start = head;
        while (start.next!=null){
            start = start.next;
        }
        start.next=temp;
        len++;

    }


    public static void insert_node(int position, int value) {
        if (position >= 0 && position <= len ) {
            if(position==0){
                insert_first(value);
                return;
            }

            Node start = head;
            for (int i = 1; i <= position-1 ; i++) {
                start = start.next;
            }
            Node temp = new Node(value);
            temp.next = start.next;
            start.next = temp;
            len++;
        }
    }
    public static void delete_node(int position) {
        if (position >= 0 && position <= len-1 ) {
            System.out.println("hii");
            if(head==null){
                return;
            }
            Node start = head;
            if (position == 0) {
                head = head.next;
                return;
            }

            for (int i = 1; i <=position - 1; i++) {
                start = start.next;
            }
            start.next = start.next.next;
            len--;

        }
    }
    public static void print_ll() {
        // Output each element followed by a space
        Node start=head;
        while (start!=null){
            System.out.print(start.data+"->");
            start=start.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        int m=Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
/*
        insert_first(1);

        insert_last(2);
        insert_node(1,3);
        print_ll();

 */




        int n=sc.nextInt();
        int [][] A=new int[n][3];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<3;j++){
                A[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<A.length;i++){
            int a=A[i][0];
            int x=A[i][1];
            int b=A[i][2];
            if(a==0 &&b==-1){
                insert_first(x);
            }
            if(a==1 &&b==-1){
                insert_last(x);
            }
            if(a==2){
                insert_node(b,x);
            }
            if(a==3&&b==-1){
                delete_node(x);
            }
        }

        print_ll();

/*
my code give different output for  input 5
2 18 0
2 5 1
2 8 0
1 7 -1
1 5 -1
should be 8->18->5->7->5->NULL

6
0 1 -1
1 2 -1
2 3 1
0 4 -1
3 1 -1
3 2 -1

4
1 3 -1
2 5 1
0 10 -1
2 15 3

5
2 18 0
2 5 1
2 8 0
1 7 -1
1 5 -1
 */


    }

}