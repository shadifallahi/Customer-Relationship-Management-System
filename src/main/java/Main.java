
import model.Customer;
import model.Interaction;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        System.out.println("================================");
        System.out.println("     Welcome to CRM System!");
        System.out.println("================================");

        try {

            // Display all customers
            List<Customer> customers = customerService.getAllCustomers();

            System.out.println("\nTotal customers: " + customers.size());

            // Display all interactions
            List<Interaction> interactions =
                    customerService.getAllInteractions();

            System.out.println("Total interactions: " + interactions.size());

            System.out.println("\nCRM System is running successfully!");

        } catch (SQLException e) {

            System.out.println("Database error: " + e.getMessage());

        }
    }
}
