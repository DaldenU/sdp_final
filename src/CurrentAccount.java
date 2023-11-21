import java.util.ArrayList;
import java.util.List;

public class CurrentAccount extends AccountDecorator implements Observable{
    private AccountType accountType;
    private double balance;

    private List<Observer> observers;

    public CurrentAccount(AccountType accountType) {
        super(null,null);
        this.accountType = accountType;
        observers = new ArrayList<>();
        this.balance = 0;
    }

    @Override
    public void operation() {

    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        notifyObservers();
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            notifyObservers();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void calculateInterest() {
        accountType.calculateInterest(balance);
    }

    @Override
    public String getDescription() {
        return "Savings Account";
    }


    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(balance);
        }
    }
}
