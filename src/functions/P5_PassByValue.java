package functions;

public class P5_PassByValue {
    public static void incMoney(int money){//here passed value is copied
        money =2*money;
    }
    public static void main(String[] args) {
        int money=100;
        incMoney(100);
        System.out.println(money);
    }
}
