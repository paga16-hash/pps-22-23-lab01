import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

}
