public class CurrentAccountType implements AccountType {
    @Override
    public double calculateInterest(double balance) {
        System.out.println("Current account doesn't provide interest");
        return 0;
    }
}
