package com.example.demo.com.example.stream;

import org.springframework.context.annotation.Role;

/**
 * Created by Base on 7/1/2019.
 */
public class StringTest {

    public static void main(String[] args)
    {
        String s= new String("imran");
        s.concat(" allauddin");
        System.out.println(s);
        String s2= new String("imran");
        String s3=s2;
        System.out.print(s==s2);
        System.out.println(s.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s3==s2);

        Student st=new Student("IMR123");
        Student st2=new Student("IMR123");
        Student st3=st2;
        System.out.print(st==st2);
        System.out.println(st.equals(st2));
        System.out.println(st2.equals(st3));
        System.out.println(st3==st2);
        System.out.println(st.hashCode()==st2.hashCode());
        System.out.println(st.hashCode()==st2.hashCode());
    }
}
 class Student
{
    public Student(String r)
    {
        r=this.getReg();
    }
    private String reg;

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
