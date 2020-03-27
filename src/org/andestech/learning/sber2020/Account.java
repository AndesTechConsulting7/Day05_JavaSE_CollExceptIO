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

    public Account(int store, long id) throws ABSException {
        checkStoreLimit(store);
        this.store = store;
        this.id = id;
    }
    // --> Empoloyee, Customer,..

    private static void checkStoreLimit(double newStore) throws ABSException {
        if( newStore > MAX || newStore < MIN )
            throw new ABSException(String.format("Store account exception: %f out of limits!", newStore));
    }

    private static void checkTranValid(double money) throws ABSException {
        if( money > MAX_TRAN || money < MIN_TRAN )
            throw new ABSException(String.format("Transaction exception: %f out of limits!", money));
    }

    public void addMoney(double money) throws ABSException {
        double newStore = store + money;
        checkTranValid(money);
        checkStoreLimit(newStore);
        this.store = newStore;

    }

    public void withdrawal(int money) throws ABSException {
        double newStore = store - money;
        checkTranValid(money);
        checkStoreLimit(newStore);
        this.store = newStore;

    }


}
