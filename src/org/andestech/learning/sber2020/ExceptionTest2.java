package org.andestech.learning.sber2020;

public class ExceptionTest2 {

    public static void main(String[] args) {
        int a=1,b,c[] = {1,2};
        try{
            b = 1*4/(a-2);
            // Networkres ns =....  .open();
            c[2]=1;
            System.out.println("End of try..");
        }
        catch (ArithmeticException ex)
        {
     System.out.println(ex);
     for ( StackTraceElement el: ex.getStackTrace())  System.out.println(el);
        }
        finally {
            System.out.println("Finally!!");
            // ns.close()
        }


        try{
            //....
        }
        finally {
           // close resourses
        }


        System.out.println("End of main..");
    }

}
