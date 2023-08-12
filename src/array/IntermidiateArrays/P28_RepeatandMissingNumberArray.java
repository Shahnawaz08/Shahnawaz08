package array.IntermidiateArrays;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class P28_RepeatandMissingNumberArray {
    public static int[] repeatedNumberBigNo(final int[] A) {
        int [] sol=new int [2];
        int N=A.length;
        BigInteger sumOforiginal=BigInteger.valueOf(N);
        sumOforiginal=sumOforiginal.multiply(BigInteger.valueOf(N+1));
        sumOforiginal=sumOforiginal.divide(BigInteger.valueOf(2));

        BigInteger sumOfSqoriginal=BigInteger.valueOf(N);
        sumOfSqoriginal=sumOfSqoriginal.multiply(BigInteger.valueOf(N+1));
        sumOfSqoriginal=sumOfSqoriginal.multiply(BigInteger.valueOf(2*N+1));
        sumOfSqoriginal=sumOfSqoriginal.divide(BigInteger.valueOf(6));
//        System.out.println(sumOforiginal);
//        System.out.println(sumOfSqoriginal);

        BigInteger sumOfGivenArray=BigInteger.valueOf(0);
        for(int i=0;i<N;i++){
            sumOfGivenArray=sumOfGivenArray.add(BigInteger.valueOf(A[i]));
        }
       // System.out.println(sumOfGivenArray);

        BigInteger sumOfSqGivenArray=BigInteger.valueOf(0);
        for(int i=0;i<N;i++){
            BigInteger temp=BigInteger.valueOf(A[i]).multiply(BigInteger.valueOf(A[i]));
            sumOfSqGivenArray=sumOfSqGivenArray.add(temp);
        }
//        System.out.println(sumOfSqGivenArray);
        BigInteger DiffOfNo=sumOfGivenArray.subtract(sumOforiginal);
        BigInteger DiffOfSqNo=sumOfSqGivenArray.subtract(sumOfSqoriginal);
        BigInteger SumeofRepeateAndMissing=DiffOfSqNo.divide(DiffOfNo);
        BigInteger r_bigval=(SumeofRepeateAndMissing.add(DiffOfNo)).divide(BigInteger.valueOf(2));
        int r=r_bigval.intValue();
        BigInteger m_bigval=SumeofRepeateAndMissing.subtract(r_bigval);
        int m=m_bigval.intValue();


        sol[0]=r;
        sol[1]=m;
        return sol;
    }
    public static int[] repeatedNumber(final int[] A) {
        int [] sol=new int [2];
        int N=A.length;
        int sumoriginal=(N*(N+1))/2;
        int sumGinarr=0;
        for(int a:A){
            sumGinarr+=a;
        }
        int sumsqoriginal=(N*(N+1)*(2*N+1))/6;
        int sumsqGinarr=0;
        for(int a:A){
            sumsqGinarr+=a*a;
        }
        int r,m;
        int diffofSq=sumsqGinarr-sumsqoriginal;
        int diffofno=sumGinarr-sumoriginal;
        int sumofMissandReo=diffofSq/diffofno;
        r=(sumofMissandReo+diffofno)/2;
        m=sumofMissandReo-r;
        sol[0]=r;
        sol[1]=m;
        return sol;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int [] solarr=repeatedNumber(arr);
       // System.out.println(Arrays.toString(solarr));
        solarr=repeatedNumberBigNo(arr);
        System.out.println(Arrays.toString(solarr));
    }
}
