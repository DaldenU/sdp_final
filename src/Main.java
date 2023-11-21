import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = Bank.getInstance();

        AccountFactory savingsAccountFactory = new SavingsAccountFactory();
        AccountFactory currentAccountFactory = new CurrentAccountFactory();

        Account savingsAccount = savingsAccountFactory.createAccount();
        Account currentAccount = currentAccountFactory.createAccount();


        LegacyAccount legacyAccount = new LegacyAccount();
        Account legacyAccountAdapter = new LegacyAccountAdapter(legacyAccount);
        
        AccountObserver accountObserver = new AccountObserver();




        // Main client interface
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please give us your name: ");
        String userName = scanner.nextLine();


        while (true) {
            System.out.println("Good day, dear " + userName
                    + "\nChoose an account type:"
                    + "\n1. Current Account"
                    + "\n2. Savings Account"
                    + "\n3. Exit");
            Integer account_num = scanner.nextInt();
            if (account_num.equals(1)) {
                Account account1 = currentAccountFactory.createAccount();
                bank.addAccount(account1);
                ((CurrentAccount) account1).addObserver(accountObserver);

                while (true) {
                    System.out.println("==============================="
                            + "\nYour account balance: "
                            + ((CurrentAccount) account1).getBalance()
                            + "\nWhat services you would like to use?"
                            + "\n1. Deposit"
                            + "\n2. Withdraw"
                            + "\n3. Calculate Interest"
                            + "\n4. Legacy operation"
                            + "\n5. Description"
                            + "\n6. Exit"
                            + "\n===============================");

                    Integer service_num = scanner.nextInt();

                    if (service_num.equals(1)) {
                        System.out.print("Enter the deposit sum: ");
                        ((CurrentAccount) account1).deposit(scanner.nextInt());
                    } else if (service_num.equals(2)) {
                        System.out.print("Enter the withdraw sum: ");
                        ((CurrentAccount) account1).withdraw(scanner.nextInt());
                        account1.operation();
                    } else if (service_num.equals(3)) {
                        ((CurrentAccount) account1).calculateInterest();
                    } else if (service_num.equals(4)) {
                        legacyAccountAdapter.operation();
                    } else if (service_num.equals(5)) {
                        Account temp = currentAccountFactory.createAccount();
                        temp = account1;
                        account1 = new AccountDecorator(account1, "flexible features");
                        System.out.println("Current Account Description: " + account1.getDescription());
                        account1 = temp;
                    } else if (service_num.equals(6)) {
                        break;
                    }
                }
            } else if (account_num.equals(2)){
                Account account2 = savingsAccountFactory.createAccount();
                bank.addAccount(account2);
                ((SavingsAccount) account2).addObserver(accountObserver);
                while (true) {

                    System.out.println("==============================="
                            + "\nYour account balance: "
                            + ((SavingsAccount) account2).getBalance()
                            + "\nWhat services you would like to use?"
                            + "\n1. Deposit"
                            + "\n2. Withdraw"
                            + "\n3. Calculate Interest"
                            + "\n4. Legacy operation"
                            + "\n5. Description"
                            + "\n6. Exit"
                            + "\n===============================");
                    Integer service_num = scanner.nextInt();

                    if (service_num.equals(1)) {
                        System.out.print("Enter the deposit sum: ");
                        ((SavingsAccount) account2).deposit(scanner.nextInt());
                    } else if (service_num.equals(2)) {
                        System.out.print("Enter the withdraw sum: ");
                        ((SavingsAccount) account2).withdraw(scanner.nextInt());
                    } else if (service_num.equals(3)) {
                        ((SavingsAccount) account2).calculateInterest();
                    } else if (service_num.equals(4)) {
                        legacyAccountAdapter.operation();
                    } else if (service_num.equals(5)) {
                        Account temp2 = savingsAccountFactory.createAccount();
                        temp2 = account2;
                        account2 = new AccountDecorator(account2, "high interest");
                        System.out.println("Savings Account Description: " + account2.getDescription());
                        account2 = temp2;
                    } else if (service_num.equals(6)) {
                        break;
                    }

                }
            } else if (account_num.equals(3)) {
                break;
            }
        }
    }
}
