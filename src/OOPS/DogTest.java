package OOPS;

public class DogTest {
    public static void main(String[] args) {
        Dog d1=new Dog();
        d1.name="Bruno";
        d1.power=5;
        //d1.age=5;
        d1.setAge(5);
        System.out.println("My age is "+d1.getAge());
        Dog d2=new Dog();
        d2.name="Pogo";
        d2.power=4;
        d2.setAge(-2);
        System.out.println("Name of dog is "+d1.name+" and its power is "+d1.power);
        System.out.println("Name of dog is "+d2.name+" and its power is "+d2.power);
        d1.introduce();
        d1.bark();
        d2.introduce();
        d2.bark();

        //creating dog object using constructor
        Dog d3=new Dog("Tommy",5,1);
        Dog d4=new Dog("Jimmy",2,4);
        d3.introduce();
        d4.introduce();

    }
}
