package lab01.example;

import lab01.example.model.AbstractBankAccount;
import lab01.example.model.AccountHolder;

public class SimpleBankAccount extends AbstractBankAccount {
    public SimpleBankAccount(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }
}
