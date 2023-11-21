public class AccountDecorator implements Account {
    protected Account decoratedAccount;
    private String description;

    public AccountDecorator(Account decoratedAccount, String description) {
        this.decoratedAccount = decoratedAccount;
        this.description = description;
    }

    @Override
    public void operation() {
        decoratedAccount.operation();
    }


    @Override
    public String getDescription() {
        return decoratedAccount.getDescription() + " with " + description;
    }
}
