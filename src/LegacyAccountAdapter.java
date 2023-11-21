public class LegacyAccountAdapter implements Account {
    private LegacyAccount legacyAccount;

    public LegacyAccountAdapter(LegacyAccount legacyAccount) {
        this.legacyAccount = legacyAccount;
    }

    @Override
    public void operation() {
        legacyAccount.legacyOperation();
    }

    @Override
    public String getDescription() {
        return null;
    }
}
