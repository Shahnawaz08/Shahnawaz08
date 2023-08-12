package OOPS;

public class Dog {
    String name;
    int power;
    private int age;
    Dog(){
        System.out.println("...i am a Dog Creator...");
    }
    Dog(String name,int power,int dogAge){
        this.name=name;
        this.power=power;
        age=dogAge;
    }


    //Setter
    void setAge(int dogage){
        if(dogage<0){
            age=1;
        }
        else{
            age = dogage;
        }
    }
    //Getter
    int getAge(){
        return age;
    }


    void introduce(){
        System.out.println("Hi i am "+name);
        System.out.println("I am "+age+" year old ");
        System.out.println("Power is "+power);

    }
    void bark(){
        for (int i=0;i<power;i++){
            System.out.print("Woof !"+" ");
        }
        System.out.println();

    }


}
