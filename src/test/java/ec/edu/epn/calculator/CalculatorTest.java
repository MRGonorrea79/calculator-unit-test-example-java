package ec.edu.epn.calculator;

import org.junit.Test;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int result = calculator.sum(2, 2);
        if(result!=4){
            Assert.fail();
        }
    }

    @Test
    public void testMinus() {
        Calculator calculator = new Calculator();
        int result = calculator.minus(5, 3);
        assertEquals(2, result);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(4, 2);
        assertEquals(2, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(4, 0);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }
}
