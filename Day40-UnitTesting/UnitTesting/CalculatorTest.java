import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc;

    // ---- Runs before EVERY test method, giving each a fresh instance ----
    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    // ---- Basic assertEquals tests ----
    @Test
    void addingTwoPositiveNumbers() {
        assertEquals(8, calc.add(5, 3));
    }

    @Test
    void addingNegativeNumbers() {
        assertEquals(-2, calc.add(-5, 3));
    }

    @Test
    void subtractingNumbers() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    void multiplyingNumbers() {
        assertEquals(15, calc.multiply(5, 3));
    }

    // ---- Testing division ----
    @Test
    void dividingNumbers() {
        assertEquals(5, calc.divide(10, 2));
    }

    // ---- assertThrows: verifying an exception IS thrown ----
    @Test
    void divisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }

    // ---- assertTrue / assertFalse ----
    @Test
    void checkingEvenNumber() {
        assertTrue(calc.isEven(4));
    }

    @Test
    void checkingOddNumber() {
        assertFalse(calc.isEven(7));
    }

    // ---- Edge cases: where tests really earn their value ----
    @Test
    void addingZero() {
        assertEquals(5, calc.add(5, 0));
    }

    @Test
    void addingLargeNumbers() {
        assertEquals(Integer.MAX_VALUE, calc.add(Integer.MAX_VALUE, 0));
    }

    @Test
    void subtractingResultingInNegative() {
        assertEquals(-5, calc.subtract(0, 5));
    }
}
