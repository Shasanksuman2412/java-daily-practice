public enum TrafficLight {
    RED, YELLOW, GREEN;

    String action() {
        switch (this) {
            case RED:
                return "Stop";
            case YELLOW:
                return "Slow down";
            case GREEN:
                return "Go";
            default:
                return "Unknown";
        }
    }

    // ---- Exercise 4: next() using ordinal() and values(), no hardcoded sequence ----
    TrafficLight next() {
        TrafficLight[] all = values();
        int nextIndex = (this.ordinal() + 1) % all.length; // wraps back to 0 after the last one
        return all[nextIndex];
    }
}
