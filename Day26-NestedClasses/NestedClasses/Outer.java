public class Outer {
    static int outerStaticField = 100;
    private int outerInstanceField = 42;

    // ---- Static nested class: independent of any Outer instance ----
    static class StaticNested {
        void display() {
            System.out.println("Static nested class can access outer STATIC field: " + outerStaticField);
            // outerInstanceField is NOT accessible here - no Outer instance exists!
        }
    }

    // ---- Inner class (non-static): tied to a specific Outer instance ----
    class Inner {
        void display() {
            System.out.println("Inner class can access outer INSTANCE field: " + outerInstanceField);
            System.out.println("Inner class can ALSO access outer static field: " + outerStaticField);
        }
    }

    // ---- Local class: defined inside a method ----
    void methodWithLocalClass() {
        class LocalHelper {
            void help() {
                System.out.println("I only exist inside methodWithLocalClass(), field: " + outerInstanceField);
            }
        }
        LocalHelper helper = new LocalHelper();
        helper.help();
    }
}
