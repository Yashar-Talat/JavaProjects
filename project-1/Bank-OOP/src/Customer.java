public class Customer {
    public String customerName;
    public String customerId;
    public Account account;


    public void displayInfoOfCustomer() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Account ID: " + account.accountId);
        System.out.println("Account Balance: " + account.balance);
    }
}
