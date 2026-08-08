public class DesignPatternsDemo {
    public static void main(String[] args) {

        // ---- Singleton pattern ----
        System.out.println("Requesting ConfigManager instance twice:");
        ConfigManager c1 = ConfigManager.getInstance(); // "created" message prints here
        ConfigManager c2 = ConfigManager.getInstance(); // NO "created" message this time - reuses c1

        System.out.println("c1 == c2 (same object)? " + (c1 == c2));
        System.out.println("c1 appName: " + c1.getAppName());

        c1.setAppName("UpdatedApp");
        System.out.println("c2 appName after changing via c1: " + c2.getAppName());
        // proves c1 and c2 are literally the SAME object - changing one changes "both"
        System.out.println("---");

        // ---- Builder pattern ----
        Pizza simplePizza = new Pizza.Builder("Medium").build(); // no toppings, just size
        System.out.println("Simple pizza: " + simplePizza);

        Pizza loadedPizza = new Pizza.Builder("Large")
                .addCheese()
                .addPepperoni()
                .addMushrooms()
                .build();
        System.out.println("Loaded pizza: " + loadedPizza);

        Pizza cheeseOnly = new Pizza.Builder("Small")
                .addCheese()
                .build();
        System.out.println("Cheese-only pizza: " + cheeseOnly);
        // notice how readable this is compared to a constructor like:
        // new Pizza("Small", true, false, false)  <- what do these booleans even mean?!
    }
}
