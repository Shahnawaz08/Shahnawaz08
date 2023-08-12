package SubsequanceAndSubset;

public class powerfunction {
    public static int power(int a,int b){
        if(b==0){
            return 1;
        }
        int pow=0;
        int halfpow=power(a,b/2);
        halfpow=halfpow%1000000007;
        if(b%2==0){
            pow=halfpow*halfpow;
            pow=pow%1000000007;
        }
        else{
            pow=a*halfpow*halfpow;
            pow=pow%1000000007;
        }
        return pow;
    }

    public static void main(String[] args) {
        int res=power(2,16);
        System.out.println(res);
    }
}
