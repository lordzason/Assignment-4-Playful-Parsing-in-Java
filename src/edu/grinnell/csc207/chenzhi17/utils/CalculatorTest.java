package edu.grinnell.csc207.chenzhi17.utils;

import java.math.BigInteger;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest
{

  @Test
  public void testEval0()
  {
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
    assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
    assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
    assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
    assertEquals(BigInteger.valueOf(1), Calculator.eval0("1 + 2 * 3 / 9"));
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("1 + 2 * 3 / 9 - 1"));
    assertEquals((BigInteger.valueOf(2)).pow(64), Calculator.eval0("2 ^ 64"));
  }
  
  //Testing does not work. I do not know how to use a fraction
  //as expected output
  @Test
  public void testEval1()
  {
    assertEquals(new Fraction (0,1), Calculator.eval1("0/1"));
    assertEquals(new Fraction (5, 6), Calculator.eval1("1/2 + 6/18"));
    assertEquals(new Fraction (19,30), Calculator.eval1("1/3 + 2/4 - 1/5"));
    assertEquals(new Fraction (1,3), Calculator.eval1("1/2 + 2/3 - 3/4 * 4/5"));
    assertEquals(new Fraction (2,5), Calculator.eval1("1/2 + 2/3 - 3/4 * 4/5 / 5/6"));
    assertEquals((new Fraction (2,8)).pow(64), Calculator.eval1("2/8 ^ 64"));
  }
  
}
