public class LegacyAccount {
    public double interest = 0.05;

    public void legacyOperation() {
        System.out.println("Your Savings account has been converted to Legacy status");
        interest = 0.5;
    }

    public double getInterest() {
        return interest;
    }
}