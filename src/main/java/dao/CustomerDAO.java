
package dao;

import database.DatabaseConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) throws SQLException {

        String sql = """
            INSERT INTO customers
            (first_name, last_name, email, phone_number, company)
            VALUES (?, ?, ?, ?, ?)
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhoneNumber());
            statement.setString(5, customer.getCompany());

            return statement.executeUpdate() > 0;
        }
    }

    public Customer getCustomerById(int customerId) throws SQLException {

        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, customerId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return new Customer(
                        resultSet.getInt("customer_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("company")
                    );
                }
            }
        }

        return null;
    }

    public List<Customer> getAllCustomers() throws SQLException {

        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customers";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer(
                    resultSet.getInt("customer_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("company")
                );

                customers.add(customer);
            }
        }

        return customers;
    }

    public boolean updateCustomer(Customer customer) throws SQLException {

        String sql = """
            UPDATE customers
            SET email = ?, phone_number = ?
            WHERE customer_id = ?
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customer.getEmail());
            statement.setString(2, customer.getPhoneNumber());
            statement.setInt(3, customer.getCustomerId());

            return statement.executeUpdate() > 0;
        }
    }

    public boolean deleteCustomer(int customerId) throws SQLException {

        String sql = "DELETE FROM customers WHERE customer_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, customerId);

            return statement.executeUpdate() > 0;
        }
    }
}
