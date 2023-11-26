public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.balance = 2000;
        account.accountId = 10;
        account.deposit(1000);
        account.withdraw(500);

        Customer customer = new Customer();
        customer.customerId = "1";
        customer.customerName = "Behzad";
        customer.account = account;
        customer.displayInfoOfCustomer();

        Branch branch = new Branch();
        branch.branchCode = "12";
        branch.branchName = "Markazi";
        branch.displayBranch();

        BankCard bankCard = new BankCard();
        bankCard.cardHolderName = "Behazd";
        bankCard.cardNumber = "5047046465644";
        bankCard.showBankCardInfo();
    }
}