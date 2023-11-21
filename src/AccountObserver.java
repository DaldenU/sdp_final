public class AccountObserver implements Observer {
    @Override
    public void update(double balance) {
        System.out.println("Account balance updated: " + balance);
    }
}
