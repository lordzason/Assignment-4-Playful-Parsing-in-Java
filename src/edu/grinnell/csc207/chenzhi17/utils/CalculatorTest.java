package edu.grinnell.csc207.chenzhi17.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest
{

  //Testing the functions of the calculator
  @Test
  public void testEval0()
  {
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
    assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
    assertEquals(BigInteger.valueOf(-2), Calculator.eval0("-1 + -1"));
    assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
    assertEquals(BigInteger.valueOf(-4), Calculator.eval0("-1 + -2 + -1"));
    assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
    assertEquals(BigInteger.valueOf(9), Calculator.eval0("-1 + -2 * -3"));
    assertEquals(BigInteger.valueOf(1), Calculator.eval0("1 + 2 * 3 / 9"));
    assertEquals(BigInteger.valueOf(-1), Calculator.eval0("-1 + -2 * -3 / -9"));
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("1 + 2 * 3 / 9 - 1"));
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("-1 + -2 * -3 / -9 - -1"));
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("0 + 0 * 0 / 1 - 0"));
    assertEquals((BigInteger.valueOf(2)).pow(64), Calculator.eval0("2 ^ 64"));
  }

  //Gratitude to Samuel Rebelsky for suggesting to compare the expected and actual outputs as strings
  //Testing the functions of the fraction calculator
  @Test
  public void testEval1()
  {
    assertEquals(new Fraction (0,1).toString(), Calculator.eval1("0/1").toString());
    assertEquals(new Fraction (5, 6).toString(), Calculator.eval1("1/2 + 6/18").toString());
    assertEquals(new Fraction (-5, 6).toString(), Calculator.eval1("-1/2 + -6/18").toString());
    assertEquals(new Fraction (19,30).toString(), Calculator.eval1("1/3 + 2/4 - 1/5").toString());
    assertEquals(new Fraction (-19,30).toString(), Calculator.eval1("-1/3 + -2/4 - -1/5").toString());
    assertEquals(new Fraction (1,3).toString(), Calculator.eval1("1/2 + 2/3 - 3/4 * 4/5").toString());
    assertEquals(new Fraction (1,3).toString(), Calculator.eval1("-1/2 + -2/3 - -3/4 * -4/5").toString());
    assertEquals(new Fraction (2,5).toString(), Calculator.eval1("1/2 + 2/3 - 3/4 * 4/5 / 5/6").toString());
    assertEquals(new Fraction (-2,5).toString(), Calculator.eval1("-1/2 + -2/3 - -3/4 * -4/5 / -5/6").toString());
    assertEquals(new Fraction (0,1).toString(), Calculator.eval1("0/1 + 0/1 - 0/1 * 0/1 / 1/1").toString());
    assertEquals((new Fraction (2,8)).pow(64).toString(), Calculator.eval1("2/8 ^ 64").toString());
  }
  
}
