public class Car {
    private final String model;
    private final String color;
    private final boolean sunroof;
    private final boolean automatic;

    private Car(Builder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
        this.automatic = builder.automatic;
    }

    @Override
    public String toString() {
        return "Car{model='" + model + "', color='" + color +
                "', sunroof=" + sunroof + ", automatic=" + automatic + "}";
    }

    public static class Builder {
        private String model;
        private String color = "White";
        private boolean sunroof = false;
        private boolean automatic = true;

        public Builder(String model) {
            this.model = model;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder sunroof() {
            this.sunroof = true;
            return this;
        }

        public Builder manualTransmission() {
            this.automatic = false;
            return this;
        }

        public Car build() {
            // ---- Exercise 4: validation before building ----
            if (model == null || model.isEmpty()) {
                throw new IllegalStateException("Car must have a model - none was provided.");
            }
            return new Car(this);
        }
    }
}
