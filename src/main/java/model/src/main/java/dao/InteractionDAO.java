
package dao;

import database.DatabaseConnection;
import model.Interaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InteractionDAO {

    // CREATE: Add a new interaction
    public void addInteraction(Interaction interaction)
            throws SQLException {

        String sql = """
            INSERT INTO interactions
            (customer_id, interaction_type, description, interaction_date)
            VALUES (?, ?, ?, ?)
            """;

        try (Connection connection =
                     DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, interaction.getCustomerId());
            statement.setString(2, interaction.getInteractionType());
            statement.setString(3, interaction.getDescription());
            statement.setString(4, interaction.getInteractionDate());

            statement.executeUpdate();
        }
    }

    // READ: Retrieve all interactions
    public List<Interaction> getAllInteractions()
            throws SQLException {

        List<Interaction> interactions = new ArrayList<>();

        String sql = "SELECT * FROM interactions";

        try (Connection connection =
                     DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Interaction interaction = new Interaction(
                    resultSet.getInt("interaction_id"),
                    resultSet.getInt("customer_id"),
                    resultSet.getString("interaction_type"),
                    resultSet.getString("description"),
                    resultSet.getString("interaction_date")
                );

                interactions.add(interaction);
            }
        }

        return interactions;
    }

    // READ: Retrieve interactions for a specific customer
    public List<Interaction> getInteractionsByCustomerId(int customerId)
            throws SQLException {

        List<Interaction> interactions = new ArrayList<>();

        String sql = """
            SELECT * FROM interactions
            WHERE customer_id = ?
            """;

        try (Connection connection =
                     DatabaseConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, customerId);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    Interaction interaction = new Interaction(
                        resultSet.getInt("interaction_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("interaction_type"),
                        resultSet.getString("description"),
                        resultSet.getString("interaction_date")
                    );

                    interactions.add(interaction);
                }
            }
        }

        return interactions;
    }
}
