package com.codecool.simplecalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SimpleCalculatorTest {

    SimpleCalculator calculator;

    @BeforeEach
    public void Setup() {
        SimpleCalculator calculator = new SimpleCalculator();
    }
    @Test
    public void testIsNumberValid() {
        Assertions.assertNotNull(calculator.isNumber("11"));
    }

    @Test
    public void testIsNumberNotValid() {
        Assertions.assertNull(calculator.isNumber("xyz"));
    }

    @Test
    public void testIsValidOperatorValid() {
        Assertions.assertTrue(calculator.isValidOperator("+"));
    }

    @Test
    public void testIsValidOperatorInvalid() {
        Assertions.assertFalse(calculator.isValidOperator("3"));
    }

    @Test
    public void testCalcPlus() {
        float a = 5f;
        float b = 7f;
        Assertions.assertEquals((Float)(a + b), calculator.calc("+", a, b));
    }

    @Test
    public void testCalcMinus() {
        float a = 5f;
        float b = 7f;
        Assertions.assertEquals((Float)(a - b), calculator.calc("-", a, b));
    }

    @Test
    public void testCalcMultiply() {
        float a = 5f;
        float b = 7f;
        Assertions.assertEquals((Float)(a * b), calculator.calc("*", a, b));
    }

    @Test
    public void testCalcDivision() {
        float a = 5f;
        float b = 7f;
        Assertions.assertEquals((Float)(a / b), calculator.calc("/", a, b));
    }

}
