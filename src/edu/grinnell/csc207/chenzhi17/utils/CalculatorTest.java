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
    assertEquals((BigInteger.valueOf(2)).pow(64), Calculator.eval0("2 ^ 64"));
  }

}
