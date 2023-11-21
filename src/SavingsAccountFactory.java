public class SavingsAccountFactory implements AccountFactory {
    @Override
    public Account createAccount() {
        return new SavingsAccount(new SavingsAccountType());
    }
}
