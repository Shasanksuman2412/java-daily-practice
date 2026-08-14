import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {

    // ---- Exercise 1: StringUtils.isPalindrome ----
    @Test
    void palindromeDetectsClearPalindrome() {
        assertTrue(new StringUtils().isPalindrome("madam"));
    }

    @Test
    void palindromeDetectsNonPalindrome() {
        assertFalse(new StringUtils().isPalindrome("hello"));
    }

    @Test
    void palindromeHandlesEmptyString() {
        assertTrue(new StringUtils().isPalindrome("")); // trivially a palindrome
    }

    @Test
    void palindromeHandlesSingleCharacter() {
        assertTrue(new StringUtils().isPalindrome("a")); // trivially a palindrome
    }

    // ---- Exercise 2: PositiveIntParser ----
    @Test
    void parsePositiveIntAcceptsValidInput() {
        assertEquals(42, new PositiveIntParser().parsePositiveInt("42"));
    }

    @Test
    void parsePositiveIntRejectsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new PositiveIntParser().parsePositiveInt("0"));
    }

    @Test
    void parsePositiveIntRejectsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new PositiveIntParser().parsePositiveInt("-5"));
    }

    // ---- Exercise 3: Counter, using @BeforeEach ----
    @Nested
    class CounterTests {
        Counter counter;

        @BeforeEach
        void setUp() {
            counter = new Counter(); // fresh Counter before every test
        }

        @Test
        void startsAtZero() {
            assertEquals(0, counter.getValue());
        }

        @Test
        void incrementIncreasesByOne() {
            counter.increment();
            assertEquals(1, counter.getValue());
        }

        @Test
        void decrementDecreasesByOne() {
            counter.decrement();
            assertEquals(-1, counter.getValue());
        }

        @Test
        void multipleIncrementsAccumulate() {
            counter.increment();
            counter.increment();
            counter.increment();
            assertEquals(3, counter.getValue());
        }
    }

    // ---- Exercise 4: ArrayUtils.findMax edge cases ----
    @Test
    void findMaxNormalArray() {
        assertEquals(89, new ArrayUtils().findMax(new int[]{45, 89, 23, 67}));
    }

    @Test
    void findMaxAllSameValue() {
        assertEquals(5, new ArrayUtils().findMax(new int[]{5, 5, 5, 5}));
    }

    @Test
    void findMaxSingleElement() {
        assertEquals(42, new ArrayUtils().findMax(new int[]{42}));
    }

    @Test
    void findMaxNegativeNumbersOnly() {
        assertEquals(-1, new ArrayUtils().findMax(new int[]{-5, -1, -10}));
    }

    @Test
    void findMaxEmptyArrayThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new ArrayUtils().findMax(new int[]{}));
    }

    // ---- Exercise 5: TDD-style - test written first, then EmailValidator implemented ----
    @Test
    void isValidEmail_rejectsMissingAtSymbol() {
        assertFalse(EmailValidator.isValid("not-an-email"));
    }

    @Test
    void isValidEmail_acceptsValidEmail() {
        assertTrue(EmailValidator.isValid("shasank@example.com"));
    }
}
