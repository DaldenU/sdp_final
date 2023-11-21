import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends AccountDecorator implements Observable {
    private AccountType accountType;
    private double balance;
    private List<Observer> observers;

    public SavingsAccount(AccountType accountType) {
        super(null, null);
        this.accountType = accountType;
        observers = new ArrayList<>();
        this.balance = 0;
    }

    @Override
    public void operation() {
        // Perform account operation
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        notifyObservers();
        // Notify observers about balance change
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            notifyObservers();
            // Notify observers about balance change
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription() {
        return "Savings Account";
    }

    public void calculateInterest() {
        double interest = accountType.calculateInterest(balance);
        balance += interest;
        System.out.println("Interest added: " + interest);
        notifyObservers();
        // Notify observers about balance change
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(balance);
        }
    }
}
