package bits_manupulation;
//Reverse the bits of an 32 bit unsigned integer A.
import java.util.Arrays;
import java.util.Scanner;
//4294967295
public class P1_ReverseANumber {
    public static long reverse2(long A) {
       long rev=0;
        int i=0;
        long power= (long) Math.pow(2,31);

        while(A>0){
            long rem=A%2;
            rev=rev+rem*power;
            i++;
            A=A/2;
            power=power/2;
            System.out.println(rev);
            System.out.println(A);

        }

        return rev;

    }
    public static long reverse(long A) {
        long[] revBin=new long [32];
        int i=0;
        int  count;
        while(A>0){
            System.out.println(A%2);
            long rem=A%2;
            System.out.print(rem+" ");
            revBin[i]=rem;
            i++;
            A=A/2;
            System.out.println(A);

        }
        System.out.println("size of no in binary is "+i);
        System.out.println(Arrays.toString(revBin));
        long revNo=0;
        long power=1;
        for(int j=31;j>=0;j--){
            long num=revBin[j]*power;
            revNo+=num;
            power*=2;
        }
        return revNo;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long N=sc.nextLong();
        long revno=reverse(N);
        System.out.println("Binary reverse of a number is "+revno);
        revno=reverse2(N);
        System.out.println(revno);


    }
}
