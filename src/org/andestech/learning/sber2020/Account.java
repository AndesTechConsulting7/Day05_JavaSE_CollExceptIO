package org.andestech.learning.sber2020;

public class Account {
    private static double MAX = 1_000_000;
    private static double MIN = 10;
    private static double MIN_TRAN = 10;
    private static double MAX_TRAN = 10_000;

    private double store; // in real world use Decimal or Money like type
    private long id;

    public double getStore(){return store;}
    public long getId(){ return id;}

    @Override
    public String toString() {
        return "Account{" +
                "store=" + store +
                ", id=" + id +
                '}';
    }

    private void setStore(double store) throws ABSException {
        if( store > MAX || store < MIN )
            throw new ABSException(String.format("Store account exception: %f out of limits!", store));
        this.store = store;
    }

    public Account(long id, double store) throws ABSException {
       // checkStoreLimit(store);
        this.setStore(store);
        this.id = id;
    }
    // --> Empoloyee, Customer,..

//    private static void checkStoreLimit(double newStore) throws ABSException {
//        if( newStore > MAX || newStore < MIN )
//            throw new ABSException(String.format("Store account exception: %f out of limits!", newStore));
//    }

    private static void checkTranValid(double money) throws ABSException {
        if( money > MAX_TRAN || money < MIN_TRAN )
            throw new ABSException(String.format("Transaction exception: %f out of limits!", money));
    }

    public void addMoney(double money) throws ABSException {
        double newStore = store + money;
        checkTranValid(money);
       // checkStoreLimit(newStore);
        this.setStore(newStore);

    }

    public void withdrawal(int money) throws ABSException {
        double newStore = store - money;
        checkTranValid(money);
       // checkStoreLimit(newStore);
        this.setStore(newStore);

    }


}
