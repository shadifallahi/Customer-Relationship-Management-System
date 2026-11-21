
package model;

public class Interaction {

    // Interaction attributes
    private int interactionId;
    private int customerId;
    private String interactionType;
    private String description;
    private String interactionDate;

    // Constructor
    public Interaction(int interactionId, int customerId,
                       String interactionType,
                       String description,
                       String interactionDate) {

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

    public String getInteractionDate() {
        return interactionDate;
    }
}
