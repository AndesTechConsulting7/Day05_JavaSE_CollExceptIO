package org.andestech.learning.sber2020;

public class UserExceptionTest
{
    private static Account processAccount1() throws ABSException {

        Account account = new Account(1216, 100_001);

        return account;
    }

    public static void main(String[] args) throws ABSException{

        try {
            Account acc = processAccount1();
            System.out.println(acc);
            acc.withdrawal(5000);
            System.out.println(acc);
         // acc.withdrawal(15000);
            acc.addMoney(3000);
            System.out.println(acc);


        }catch (ABSException ex){
            //Logging ...
            throw ex;
        }

    }
}
