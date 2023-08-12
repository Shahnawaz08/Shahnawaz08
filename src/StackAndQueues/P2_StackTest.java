package StackAndQueues;

public class P2_StackTest {
    public static void main(String[] args) {
        StackImplmnt S=new StackImplmnt();
        S.push(1);
        S.push(2);
        S.push(3);
        S.pop();
        S.push(4);
        S.push(5);
        StackImplmnt T=new StackImplmnt();
        T.head=S.head;
        while (T.head!=null){
            System.out.println(T.head.data);
            T.head=T.head.next;
        }
        System.out.println("Second method");

        //In this print method element ofn stack is deleted
        System.out.println(S.empty());
        while (!S.empty()){
            System.out.println(S.top());
            S.pop();
//            System.out.println(S);


        }


        //System.out.println(S.empty());
    }
}
