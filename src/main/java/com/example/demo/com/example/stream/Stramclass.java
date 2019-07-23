package com.example.demo.com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 * Created by Base on 6/19/2019.
 */
public class Stramclass {
    public static void main(String[] args){

        List<Integer> values= Arrays.asList(1,2,3,4,5,6,7);

        values.forEach(integer -> System.out.println(integer));      // 1. we can expend this line into the following way
        System.out.print("-------a-------");

        values.forEach(System.out::println); // This is called Method Reference this is alternative to point 1 and it is also a lambda expression
        System.out.print("--------c------");
        values.forEach(i->doubleit(i));
        values.forEach(Stramclass::doubleit);
        System.out.print("--------b------");

           Consumer<Integer> c =new Consumer<Integer>() {           //  2. we can srink this annonymous method into the following way
              @Override
              public void accept(Integer integer) {
               System.out.println(integer);
              }
          };
          values.forEach(c);
          System.out.println("--------------");

          Consumer<Integer> ci=(Integer i)->System.out.println(i);   //  3. As we can srink this code to the following way as we know consumer is of type Integer
          values.forEach(ci);
          System.out.print("--------------");

          Consumer<Integer> cii=(i)->System.out.println(i);           // If there is only one parameter there is no requirement of ()
          values.forEach(cii);
          System.out.print("--------------");

          Consumer<Integer> ciii=i->System.out.println(i);
          values.forEach(ciii);
          System.out.print("--------------------------------------------------------------------");

          values.stream().forEach(System.out::println);

       /*  System.out.println(values.stream().filter(i->{
             System.out.println("hi");
             return i%2==0;
         }).findFirst().orElse(0));*/

          System.out.print("------------------xxx------------------------");
          System.out.println(values.stream().map(i->i*2).reduce(0,(a,b)->a+b));  // Explanation of this code is given below with example annonymous class

        System.out.print("---------------------alternative---------------------");
        System.out.println(values.stream().map(i->i*2).reduce(0,(a,b)->Integer.sum(a,b)));

        System.out.print("---------------------alternative1---------------------");
        System.out.println(values.stream().map(i->i*2).reduce(0,Integer::sum));

           Function<Integer,Integer> f=new Function<Integer, Integer>() {
               @Override
               public Integer apply(Integer integer) {
                   return  integer*2;
               }
           };
          BinaryOperator<Integer> b= new BinaryOperator<Integer>() {
              @Override
              public Integer apply(Integer integer, Integer integer2) {
                  return integer+integer2;
              }
          };

          Stream s=values.stream();
          Stream si=s.map(f);
          Integer sii =(Integer) si.reduce(0,b);
          //si.forEach(System.out::println); // checking multiplication with 2 is happening or not
                                             // N.B: This line may or may not show error because
          System.out.println(sii);

    }

    // some Funtional interfates used here are 1. Consumer is of forEach method 2. Funtion is of map() function 3.  BinaryOperator is of reduce() method
    // 4. Predicate is of filter() method

    public static  void doubleit(Integer i)
    {
          System.out.println(i*2);
    }
}
