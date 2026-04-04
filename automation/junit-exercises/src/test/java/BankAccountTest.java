import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount(100);
    }

    @Test
    void depositIncreaseBalance() {

        account.deposit(50);

        Assertions.assertEquals(150, account.getBalance());
    }

    @Test
    void depositWithZeroAmountThrowException() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0)
        );
    }

    @Test
    void withdrawMoreThanBalanceThrowException() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(200)
        );
    }

    @Test
    void withdrawZeroAmountThrowException() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(0)
        );
    }

    @Test
    void newAccountHasCorrectBalance() {

        BankAccount newAccount = new BankAccount(500);
        Assertions.assertEquals(500, newAccount.getBalance());
    }
}
