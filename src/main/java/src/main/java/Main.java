
import database.DatabaseInitializer;
import model.Customer;
import service.CustomerService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the CRM System!");

        // Initialize the database
        DatabaseInitializer.initialize();

        // Create customer service
        CustomerService customerService = new CustomerService();

        // Retrieve all customers
        List<Customer> customers = customerService.getAllCustomers();

        // Display customer information
        System.out.println("Total customers: " + customers.size());

        System.out.println("CRM System started successfully!");
    }
}
