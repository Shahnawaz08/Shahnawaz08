package functions;

public class P2FunctionInteraction {
    public static boolean signIn(String userName){
        if(userName.equals("Shahnawaz")){
            return true;
        }
        return false;
    }

    public static boolean uploadVidio(String vidioName,String userName){
        boolean signInSuccess=signIn(userName);
        if(signInSuccess){
            System.out.println("Uploading Video....");
        }
        else{
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean success=uploadVidio("Maths","Shahnawaz");
        if(success){
            System.out.println("Video is uploaded successfully");
        }
        else {
            System.out.println("Oops Something Went Wrong");
        }
    }
}
