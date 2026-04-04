import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    // object we are testing - declared here so all tests can access it
    private BankAccount account;

    // runs before each test - creates a fresh account with balance 100
    @BeforeEach
    void setup() {
        account = new BankAccount(100);
    }


    // --- DEPOSIT TESTS ---

    @Test
    void depositIncreaseBalance() {

        // Act
        account.deposit(50);

        // Assert - initial balance was 100, deposited 50, so balance should be 150
        Assertions.assertEquals(150, account.getBalance());
    }

    @Test
    void depositWithZeroAmountThrowException() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0)
        );
    }

    // --- WITHDRAW TESTS ---

    @Test
    void withdrawDecreaseBalance() {

        // Act
        account.withdraw(30);

        // Assert - initial balance was 100, withdrew 30, so balance should be 70
        Assertions.assertEquals(70, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceThrowException() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(200)  // we only have 100, trying to withdraw 200
        );
    }

    @Test
    void withdrawZeroAmountThrowException() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(0)
        );
    }

    // --- CONSTRUCTOR TESTS ---

    @Test
    void newAccountHasCorrectBalance() {

        BankAccount newAccount = new BankAccount(500);
        Assertions.assertEquals(500, newAccount.getBalance());
    }

    @Test
    void accountWithNegativeInitialBalanceThrowException() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount(-100)
        );
    }
}
