package array.OneDarrays;

import java.util.Arrays;

public class P2_MoneyDoubleChallenge {
    public static void moneyDouble(int [] money){
        for(int i=0;i<money.length;i++){
            money[i]=2*money[i];
        }

    }

    public static void main(String[] args) {
        int [] friends_money ={10,20,30};
        System.out.println(Arrays.toString(friends_money));
        moneyDouble(friends_money);
        System.out.println(Arrays.toString(friends_money));
    }
}
