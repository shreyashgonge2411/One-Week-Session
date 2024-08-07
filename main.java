import java.util.*;

class Customer {
    private int customerId;
    private String name;
    private String email;

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Email: " + email;
    }
}

class CustomerManagementSystem {
    private Map<Integer, Customer> customers = new HashMap<>();

    public void addCustomer(int customerId, String name, String email) {
        if (customers.containsKey(customerId)) {
            System.out.println("Customer ID already exists.");
        } else {
            customers.put(customerId, new Customer(customerId, name, email));
            System.out.println("Customer added successfully.");
        }
    }

    public void removeCustomer(int customerId) {
        if (customers.containsKey(customerId)) {
            customers.remove(customerId);
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer ID not found.");
        }
    }

    public void searchCustomer(int customerId) {
        if (customers.containsKey(customerId)) {
            System.out.println(customers.get(customerId));
        } else {
            System.out.println("Customer ID not found.");
        }
    }

    public void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers.values()) {
                System.out.println(customer);
            }
        }
    }

    public void sortCustomersByName() {
        List<Customer> customerList = new ArrayList<>(customers.values());
        customerList.sort(Comparator.comparing(Customer::getName));
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    public void sortCustomersById() {
        List<Customer> customerList = new ArrayList<>(customers.values());
        customerList.sort(Comparator.comparingInt(Customer::getCustomerId));
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}

public class main {
    public static void main(String[] args) {
        CustomerManagementSystem cms = new CustomerManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. List All Customers");
            System.out.println("5. Sort Customers by Name");
            System.out.println("6. Sort Customers by ID");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    cms.addCustomer(id, name, email);
                    break;
                case 2:
                    System.out.print("Enter Customer ID to remove: ");
                    int removeId = scanner.nextInt();
                    cms.removeCustomer(removeId);
                    break;
                case 3:
                    System.out.print("Enter Customer ID to search: ");
                    int searchId = scanner.nextInt();
                    cms.searchCustomer(searchId);
                    break;
                case 4:
                    cms.listAllCustomers();
                    break;
                case 5:
                    cms.sortCustomersByName();
                    break;
                case 6:
                    cms.sortCustomersById();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
