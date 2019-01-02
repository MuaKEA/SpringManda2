package com.example.demo.abstration;


abstract class Abtractionclass {
   public String name;
   public int age;

   public Abtractionclass(String name, int age){
     this.name=name;
     this.age=age;
    }

    public String toString() {
        return name + " " + age;
    }

    abstract void abstractmethod();

   public static void display2() {
        System.out.println("abtration virker");

    }
}

class Test extends Abtractionclass {

    public Test(String name,int age){
        super(name,age);

    }




    public static void main(String[] args) {
        display2();
        Test test= new Test("name",20);
        test.abstractmethod();
        System.out.println(test);
    }
    void abstractmethod() {
        System.out.println("implamentere abstract metode");
    }






}


