package lab01.example;

import lab01.example.model.AbstractBankAccount;
import lab01.example.model.AccountHolder;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {
    private static final int ATM_OPERATION_FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += (amount - ATM_OPERATION_FEE);
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount + ATM_OPERATION_FEE)) {
            this.balance -= (amount + ATM_OPERATION_FEE);
        }
    }
}
