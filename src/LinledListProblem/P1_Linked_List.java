package LinledListProblem;
class node{
    int data;
    node next;
    node(int val){
        data=val;
        next=null;
    }

}

public class P1_Linked_List {
    static node head=null;
    static int len=0;
//    public static class node{
//        int data;
//        node next;
//        node(int val){
//            data=val;
//            next=null;
//        }
//
//    }
    public static void insert_first(int val){
        node temp=new node(val);
        temp.next=head;
        head=temp;

    }


    public static void insert_node(int position, int value) {
        if (position >= 1 && position <= len+1 ) {
            if (position == 1) {
                insert_first(value);
                len++;
                return;
            }
            node start = head;
            for (int i = 1; i < position - 1; i++) {
                start = start.next;
            }
            node temp = new node(value);
            temp.next = start.next;
            start.next = temp;
            len++;
        }
    }
    public static void delete_node(int position) {
        if (position > 0 && position <= len ) {
            node start = head;
            if (position == 1) {
                head = head.next;
                return;
            }

            for (int i = 1; i < position - 1; i++) {
                start = start.next;
            }
            start.next = start.next.next;

        }
    }
    public static void print_ll() {
        // Output each element followed by a space
        node start=head;
        while (start!=null){
            System.out.print(start.data+" ");
            start=start.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        delete_node(1);
        insert_node(1,1);
        insert_node(1,2);
        insert_node(3,3);
        insert_node(2,4);
        print_ll();
        delete_node(len+1);
        print_ll();





    }
}
