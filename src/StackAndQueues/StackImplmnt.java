package StackAndQueues;
class Node{
    int data;
    Node next;
    Node(int val){
        data =val;
        Node next =null;
    }
}

public class StackImplmnt {
    Node head;
    int min;
    //Initialization of Stack
    StackImplmnt(){
        head=null;
    }
    //Push
    void push(int d){
        Node n=new Node(d);
        n.next=head;
        head=n;
    }
    void pop(){
        if(head!=null){
            head=head.next;
        }
    }
    int top(){
        return head.data;
    }
    boolean empty(){
        return head==null;
    }
}
