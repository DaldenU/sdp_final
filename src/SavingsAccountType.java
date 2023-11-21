public class SavingsAccountType implements AccountType {

    LegacyAccount legA = new LegacyAccount();
    double interestRate = legA.getInterest();

    @Override
    public double calculateInterest(double balance) {
        System.out.println("int: " + interestRate);
        return balance * interestRate;
    }
}
