
package service;

import dao.CustomerDAO;
import dao.InteractionDAO;
import model.Customer;
import model.Interaction;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO;
    private InteractionDAO interactionDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
        this.interactionDAO = new InteractionDAO();
    }

    // Customer operations

    public boolean addCustomer(Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDAO.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public boolean updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    public boolean deleteCustomer(int customerId) {
        return customerDAO.deleteCustomer(customerId);
    }

    // Interaction operations

    public void addInteraction(Interaction interaction)
            throws SQLException {
        interactionDAO.addInteraction(interaction);
    }

    public List<Interaction> getAllInteractions()
            throws SQLException {
        return interactionDAO.getAllInteractions();
    }

    public List<Interaction> getInteractionsByCustomerId(int customerId)
            throws SQLException {
        return interactionDAO.getInteractionsByCustomerId(customerId);
    }
}

