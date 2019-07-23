package com.example.demo.com.example.stream;

/**
 * Created by Base on 7/7/2019.
 */
public class OverloadingCalculation3 {
    void sum(long b){System.out.println("a method invoked");}
    void sum(int b){System.out.println("b method invoked");}

  /*  public static void main(String args[]){
        OverloadingCalculation3 obj=new OverloadingCalculation3();
        obj.sum(20);   //now ambiguity
    }*/
}
class Base
{
    Base()
    {
        System.out.println("Default");
    }
    Base(int a, int b)
    {
        System.out.println("a method invoked");
    }
    Base(double a, int b)
    {
        System.out.println("a method invoked");
    }
 /*   void method(int a)
    {
        System.out.println("Base class method called with integer a = "+a);
    }*/

    void method(long d)
    {
        System.out.println("Base class method called with double d ="+d);
    }
}

class Derived extends Base
{
    @Override
    void method(long d)
    {
        System.out.println("Derived class method called with double d ="+d);
    }
}

 class Main
{
    public static void main(String[] args)
    {
        new Derived().method(10);
        new Base(10,10).method(10);
    }


   /* final static int i;
    static
    {
        i = 20;
    }
    public static void main(String args[]){

        System.out.println(i);
    }*/
}
