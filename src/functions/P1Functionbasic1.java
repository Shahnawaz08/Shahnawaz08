package functions;

public class P1Functionbasic1 {
    public static int market(int total,int num,String name){
        System.out.println(name);
        int left=total-35*num;
        return left;//negative value is returned
    }
    public static void main(String[] args) {
        int left=market(100,4,"mango");
        System.out.println(left);


    }
}
