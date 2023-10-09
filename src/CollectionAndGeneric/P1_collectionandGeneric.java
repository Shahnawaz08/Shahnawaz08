package CollectionAndGeneric;
/*
Find below the code of a class “Car”. We intend to use the objects of this class in a PriorityQueue.

public class Car {
    private int speed;
    private int power;
    public Car(int speed, int power){
        this.speed = speed;
        this.power = power;
    }

    @Override
    public String toString() {
        return "[S=" + this.speed + ", P=" + this.power + "]";
    }
}
Make the “Car” class implement Comparable interface appropriately, so that the Car with lower speed is considered smaller.
 */

//import java.util.PriorityQueue;
//
//public class P1_collectionandGeneric {
//    static class Car extends Object {
//        private int speed;
//        private int power;
//        public Car(int speed, int power){
//            this.speed = speed;
//            this.power = power;
//        }
//
//        @Override
//        public String toString() {
//            return "[S=" + this.speed + ", P=" + this.power + "]";
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        Car c1=new Car(4,200);
//        Car c2=new Car(4,300);
//        Car c3=new Car(6,500);
//        PriorityQueue<Car> pq=new PriorityQueue<>();
//        pq.add(c1);
//        pq.add(c2);
//        pq.add(c3);
//        System.out.println(pq);
//    }
//}
import java.util.PriorityQueue;

public class P1_collectionandGeneric {
    static class Car extends Object implements Comparable<Car> {
        private int speed;
        private int power;

        public Car(int speed, int power){
            this.speed = speed;
            this.power = power;
        }

        @Override
        public String toString() {
            return "[S=" + this.speed + ", P=" + this.power + "]";
        }

        @Override
        public int compareTo(Car other) {
            // Implement comparison logic based on your requirements
            // For example, compare by speed and then by power
            return this.speed - other.speed;

        }
    }

    public static void main(String[] args) {
        Car c1 = new Car(8, 200);
        Car c2 = new Car(4, 300);
        Car c3 = new Car(6, 500);
        PriorityQueue<Car> pq = new PriorityQueue<>();
        pq.add(c1);
        pq.add(c2);
        pq.add(c3);
        System.out.println(pq);
    }
}




