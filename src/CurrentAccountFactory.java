public class CurrentAccountFactory implements AccountFactory {
    @Override
    public Account createAccount() {
        return new CurrentAccount(new CurrentAccountType());
    }
}
