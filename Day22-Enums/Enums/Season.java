public enum Season implements Describable {
    WINTER(5.0) {
        @Override
        public String describe() {
            return "Cold and snowy";
        }
    },
    SPRING(15.0) {
        @Override
        public String describe() {
            return "Mild and blooming";
        }
    },
    SUMMER(30.0) {
        @Override
        public String describe() {
            return "Hot and sunny";
        }
    },
    FALL(12.0) {
        @Override
        public String describe() {
            return "Cool and windy";
        }
    };

    private final double avgTemperature;

    Season(double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    double getAvgTemperature() {
        return avgTemperature;
    }

    boolean isWarm() {
        return avgTemperature > 15.0;
    }
}
