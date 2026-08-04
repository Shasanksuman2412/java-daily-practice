public enum OrderStatus {
    PLACED, SHIPPED, DELIVERED, CANCELLED;

    boolean canTransitionTo(OrderStatus newStatus) {
        switch (this) {
            case PLACED:
                return newStatus == SHIPPED || newStatus == CANCELLED;
            case SHIPPED:
                return newStatus == DELIVERED || newStatus == CANCELLED;
            case DELIVERED:
                return false; // DELIVERED is final - no valid transitions out of it
            case CANCELLED:
                return false; // CANCELLED is final too
            default:
                return false;
        }
    }
}
