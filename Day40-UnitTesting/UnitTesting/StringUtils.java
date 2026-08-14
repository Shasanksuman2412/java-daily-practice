public class StringUtils {
    boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}

class PositiveIntParser {
    int parsePositiveInt(String s) {
        int value = Integer.parseInt(s);
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be positive, got: " + value);
        }
        return value;
    }
}

class Counter {
    private int value = 0;

    void increment() {
        value++;
    }

    void decrement() {
        value--;
    }

    int getValue() {
        return value;
    }
}

class ArrayUtils {
    int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Cannot find max of an empty array");
        }
        int max = arr[0];
        for (int n : arr) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}

class EmailValidator {
    static boolean isValid(String email) {
        return email != null && email.contains("@") && email.indexOf("@") > 0;
    }
}
