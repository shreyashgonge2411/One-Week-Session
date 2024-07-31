import java.util.Random;
import java.util.Scanner;

class Customer {
    String name;
    long accountnumber;
    double total = 5000;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public void Deposit(double amount) {
        total += amount;
        System.out.println("Amount Deposited Successfully");
    }

    public void withdraw(double amount) {
        if (total < amount) {
            System.out.println("Insufficient Balance");
        } else {
            total -= amount;
            System.out.println("Amount Withdrawn Successfully");
        }
    }

    public void balance() {
        System.out.println("Current Balance: " + total);
    }
}

public class Account {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer cs = null;  // Declare Customer object here to maintain state

        while (true) {
            System.out.println("1. Create an Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Customer Info");
            System.out.println("6. Exit");

            System.out.print("Enter a Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    cs = new Customer();  // Initialize the Customer object
                    Random rnd = new Random();
                    long accno = 100000000L + rnd.nextInt(900000000);  // Generate account number in the range [100000000, 999999999]
                    cs.setAccountnumber(accno);
                    System.out.println("Account No: " + cs.getAccountnumber());

                    System.out.print("Enter a Name: ");
                    sc.nextLine();  // Consume the newline character
                    String name = sc.nextLine();
                    cs.setName(name);
                    System.out.println("Account Created Successfully");
                    break;
                case 2:
                    if (cs == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    cs.Deposit(deposit);
                    break;
                case 3:
                    if (cs == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter withdraw amount: ");
                    double withdraw = sc.nextDouble();
                    cs.withdraw(withdraw);
                    break;
                case 4:
                    if (cs == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    cs.balance();
                    break;
                case 5:
                    if (cs == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    System.out.println("Customer Name: " + cs.getName());
                    System.out.println("Account Number: " + cs.getAccountnumber());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();  // Close the Scanner object
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}
