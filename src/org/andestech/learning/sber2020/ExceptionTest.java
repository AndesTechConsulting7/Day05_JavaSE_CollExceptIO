package org.andestech.learning.sber2020;


class A{};
class B{};

public class ExceptionTest {
    private static void test3() throws ClassNotFoundException{
        //...
        Class.forName("aa.cc.B");
    }

    private static void test1() throws ClassNotFoundException{
        int a=1, b=0, c[]={1,2,3};
        b = 12*23/(a-2);
        c[2]= 123;
        Object o = new A();
        //B b2 = (B)o;
        test3();
    }

    private static int test2(){
        int a=1, b=0;
        b = 12*23/(a-1);
        return b;
    }

    public static void main(String[] args) throws ClassNotFoundException{

        //..
        try {
            test1();
            System.out.println("End of try block..");
        }catch (ArithmeticException | ClassCastException ex){
            // e.g. log to .. db, file, ...
            System.out.println(ex);
            for ( StackTraceElement el: ex.getStackTrace())
            {
                System.out.println(el);
            }
            // Log.log(full,data);
            throw ex;
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("ARRAYS!!" + ex);
            for ( StackTraceElement el: ex.getStackTrace())
            {
                System.out.println(el);
            }
            // do smth....
        }
        catch (Exception ex){
            System.out.println("Gen. Excep:" + ex);
            for ( StackTraceElement el: ex.getStackTrace())
            {
                System.out.println(el);
            }
            // Log.log(full,data);
            throw ex;
        }


        //int res = test2();

        ///...

        System.out.println("end of main..");
    }
}
