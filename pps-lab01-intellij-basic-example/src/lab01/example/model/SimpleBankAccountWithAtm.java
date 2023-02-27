package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount{
    private static final int ATM_OPERATION_FEE = 1;
    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    public void depositFromAtm(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount - ATM_OPERATION_FEE;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    public void withdrawFromAtm(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount + ATM_OPERATION_FEE)) {
            this.balance -= amount - ATM_OPERATION_FEE;
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
