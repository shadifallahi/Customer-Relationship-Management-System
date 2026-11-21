
import model.Customer;
import service.CustomerService;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        System.out.println("Welcome to the CRM System!");

        List<Customer> customers = customerService.getAllCustomers();

        System.out.println("Total customers: " + customers.size());
    }
}
