import java.util.Arrays;
public class Account {
    private static int accountNumber;
    private static double currentBalance;
    private static double[] depositAmounts;
    public Account(int accountNumber, double currentBalance) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.depositAmounts = new double[0];
    }
    public static void withdraw(double amount, int enteredAccountNumber) {
        if (enteredAccountNumber == accountNumber) {
            if (amount > currentBalance) {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Incorrect number of account.");
        }
    }
    public static void deposit(double amount, int enteredAccountNumber) {
        if (enteredAccountNumber == accountNumber) {
            currentBalance += amount;

            double[] newDepositAmounts = new double[depositAmounts.length + 1];
            System.arraycopy(depositAmounts, 0, newDepositAmounts, 0, depositAmounts.length);
            newDepositAmounts[depositAmounts.length] = amount;
            depositAmounts = newDepositAmounts;

            System.out.println("Current balance: $" + currentBalance);
        } else {
            System.out.println("Incorrect number of account.");
        }
    }
    public void getDepositAmounts() {
        System.out.println(Arrays.toString(depositAmounts));
    }
    public void clearHist() {
        depositAmounts = new double[0];
        System.out.println("History of deposits are clean.");
    }
    public void getMaxDeposit() {
        if (depositAmounts.length > 0) {
            double maxDeposit = depositAmounts[0];
            for (int i = 1; i < depositAmounts.length; i++) {
                if (depositAmounts[i] > maxDeposit) {
                    maxDeposit = depositAmounts[i];
                }
            }
            System.out.println("Maximum deposit: $" + maxDeposit);
        } else {
            System.out.println(-1);
        }
    }
    public void getMinDeposit() {
        if (depositAmounts.length > 0) {
            double minDeposit = depositAmounts[0];
            for (int i = 0; i < depositAmounts.length; i++) {
                if (depositAmounts[i] < minDeposit) {
                    minDeposit = depositAmounts[i];
                }
            }
            System.out.println("Minimum deposit: $" + minDeposit);
        } else {
            System.out.println(-1);
        }
    }
    public static void main(String[] arguments) {
        Account account = new Account(56789653, 10000);
        account.withdraw(11000, 56789653);
        account.deposit(1000, 56789653);
        account.deposit(2000, 56789653);
        account.getDepositAmounts();
        account.clearHist();
        account.getMaxDeposit();
        account.getMinDeposit();
    }
}
