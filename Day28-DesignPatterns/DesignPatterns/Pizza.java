public class Pizza {
    private final String size;       // required
    private final boolean cheese;    // optional
    private final boolean pepperoni; // optional
    private final boolean mushrooms; // optional

    private Pizza(Builder builder) { // PRIVATE constructor - only Builder can create a Pizza
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    @Override
    public String toString() {
        return "Pizza{size='" + size + "', cheese=" + cheese +
                ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + "}";
    }

    public static class Builder {
        private String size;
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean mushrooms = false;

        public Builder(String size) { // required field goes in Builder's constructor
            this.size = size;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this; // returning "this" allows CHAINING
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Builder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
