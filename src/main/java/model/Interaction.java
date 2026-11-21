
package model;

import java.time.LocalDateTime;

public class Interaction {

    private int interactionId;
    private int customerId;
    private String interactionType;
    private String description;
    private LocalDateTime interactionDate;

    // Constructor
    public Interaction(int interactionId, int customerId,
                       String interactionType, String description,
                       LocalDateTime interactionDate) {
        this.interactionId = interactionId;
        this.customerId = customerId;
        this.interactionType = interactionType;
        this.description = description;
        this.interactionDate = interactionDate;
    }

    // Getters
    public int getInteractionId() {
        return interactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getInteractionType() {
        return interactionType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getInteractionDate() {
        return interactionDate;
    }

    // Setters
    public void setInteractionId(int interactionId) {
        this.interactionId = interactionId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setInteractionType(String interactionType) {
        this.interactionType = interactionType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInteractionDate(LocalDateTime interactionDate) {
        this.interactionDate = interactionDate;
    }
}
