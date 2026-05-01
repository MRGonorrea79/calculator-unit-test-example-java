package ec.edu.epn.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void initAll() {
        System.out.println("=== INICIANDO PRUEBAS ===");
    }

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("Suma prueba")
    @Test
    public void testSum() {
        int result = calculator.sum(2, 2); // Act
        assertEquals(4, result); // Assert
    }

    @Test
    public void testMinus() {
        Calculator calculator = new Calculator();
        int result = calculator.minus(2, 1);
        assertEquals(1, result);
    }

    @Test
    public void testDivideSuccess() {
        int result = calculator.divide(4, 2);
        assertEquals(2, result);
    }

    @Test
    public void testDivideFail() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(4, 0);
        });
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1, 3",
            "5, 5, 10",
            "10, -2, 8",
            "0, 0, 0"
    })
    public void testSumMultipleData(int a, int b, int expected) {
        int result = calculator.sum(a, b);
        assertEquals(expected, result);
    }

    @DisplayName("Multiple validations")
    @Test
    public void testMultipleAssertions() {
        assertAll(
                () -> assertEquals(4, calculator.sum(2, 2)),
                () -> assertEquals(2, calculator.divide(2, 1)),
                () -> assertEquals(6, calculator.multiply(2, 3))
        );
    }

    @Disabled("In quee")
    @Test
    public void testDisabled() {
        assertEquals(1, calculator.minus(2, 1));
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("=== FINALIZANDO PRUEBAS ===");
    }
}
