package functions;

public class P2Area {
    public static float areaOfCircle(int radius){
        float area = (float) Math.PI*radius*radius;
        return area;
    }
    public static void main(String[] args) {
        int radius=20;
        System.out.println("Area of a circle "+areaOfCircle(radius));
    }
}
