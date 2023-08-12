package Strings.StringBuilderProgs;

public class P2_StringVsStringBuilder {
    public static void appendStringBuilder(int n){
        StringBuilder sb=new StringBuilder();
        sb.ensureCapacity(n);
        for(int i=0;i<n;i++){
            sb.append('A');//take n unit of time
            //System.out.println(sb);
        }

    }

    //Appending to String N times(Not possible),creating a new string everytime
    public static void appendString(int n){
        String s="";
        for(int i=0;i<n;i++){//take n2 unit of time
            s=s+"A";
        }
    }


    public static void main(String[] args) {
        long starttime=System.currentTimeMillis();
        appendStringBuilder(1000000);
        long endtime=System.currentTimeMillis();
        System.out.println("StringBuilder took : "+ (endtime-starttime));
        starttime=System.currentTimeMillis();
        appendString(1000000);
        endtime=System.currentTimeMillis();
        System.out.println("String took : "+ (endtime-starttime));

    }
}
