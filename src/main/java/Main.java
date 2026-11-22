
import database.DatabaseInitializer;
import model.Customer;
import model.Interaction;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("     Welcome to CRM System!");
        System.out.println("================================");

        // Initialize database
        DatabaseInitializer.initializeDatabase();

        CustomerService customerService = new CustomerService();

        try {

            List<Customer> customers =
                    customerService.getAllCustomers();

            List<Interaction> interactions =
                    customerService.getAllInteractions();

            System.out.println("\nTotal customers: " + customers.size());

            System.out.println("Total interactions: "
                    + interactions.size());

            System.out.println("\nCRM System is running successfully!");

        } catch (SQLException e) {

            System.out.println("Database error: " + e.getMessage());

        }
    }
}

