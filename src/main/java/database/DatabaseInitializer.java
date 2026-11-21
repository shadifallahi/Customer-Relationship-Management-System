
package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {

        String createCustomersTable = """
            CREATE TABLE IF NOT EXISTS customers (
                customer_id INTEGER PRIMARY KEY AUTOINCREMENT,
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                email TEXT NOT NULL UNIQUE,
                phone_number TEXT,
                company TEXT
            );
            """;

        String createInteractionsTable = """
            CREATE TABLE IF NOT EXISTS interactions (
                interaction_id INTEGER PRIMARY KEY AUTOINCREMENT,
                customer_id INTEGER NOT NULL,
                interaction_type TEXT NOT NULL,
                description TEXT,
                interaction_date TEXT NOT NULL,
                FOREIGN KEY (customer_id)
                    REFERENCES customers(customer_id)
            );
            """;

        try (Connection connection =
                 DatabaseConnection.getConnection()) {

            try (Statement statement = connection.createStatement()) {

                statement.execute(createCustomersTable);
                statement.execute(createInteractionsTable);

                System.out.println("Database tables created successfully!");

            }

        } catch (SQLException e) {
            System.out.println("Database initialization failed: "
                    + e.getMessage());
        }
    }
}
