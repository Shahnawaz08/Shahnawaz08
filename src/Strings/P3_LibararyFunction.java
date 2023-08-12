package Strings;


public class P3_LibararyFunction {
    public static void main(String[] args) {
        String [] filesnames= {"dsc01.jpg","mydoc.pdf","hello.exe","photo.png","explore.exe,"};
        for (int i=0;i<filesnames.length;i++){
            if(filesnames[i].endsWith(".png")||filesnames[i].endsWith(".jpg")){
                System.out.println(filesnames[i]);
            }
        }

//        for (int i=0;i<filesnames.length;i++){
//            System.out.println(filesnames[i].split(".")[1].equals("png"));
//        }

    }


}
