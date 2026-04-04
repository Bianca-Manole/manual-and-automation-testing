public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if(initialBalance < 0){
            throw new IllegalArgumentException("Balanta initiala nu poate fi negativa");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Suma depusa trebuie sa fie pozitiva");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Suma retrasa trebuie sa fie pozitiva");
        }

        if(amount > balance) {
            throw new IllegalArgumentException("Fonduri insuficiente");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
