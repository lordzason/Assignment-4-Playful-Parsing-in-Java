package edu.grinnell.csc207.chenzhi17.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest
{

  @Test
  public void test()
  {
    Fraction f1;
    f1 = new Fraction(-10, 3);
    Fraction f2;
    f2 = new Fraction(2, 5);
    Fraction f3;
    f3 = new Fraction(5, -9);
    Fraction f4;
    f4 = new Fraction(-7, -4);
    Fraction f5;
    f5 = new Fraction(0, 1);

    //Fractional Tests
    assertEquals(new Fraction(1,3).toString(), new Fraction(10,3).fractional().toString());
    assertEquals(new Fraction(-1,3).toString(), new Fraction(-10,3).fractional().toString());
    assertEquals(new Fraction(-1,3).toString(), new Fraction(10,-3).fractional().toString());
    assertEquals(new Fraction(1,3).toString(), new Fraction(-10,-3).fractional().toString());
    
    //Negation Tests
    assertEquals(new Fraction(10,3).toString(), f1.negate().toString());
    assertEquals(new Fraction(-2,5).toString(), f2.negate().toString());
    assertEquals(new Fraction(5,9).toString(), f3.negate().toString());
    assertEquals(new Fraction(-7,4).toString(), f4.negate().toString());
    assertEquals(new Fraction(0,4).toString(), f5.negate().toString());

    //Addition Tests
    assertEquals(new Fraction(-44,15).toString(), f1.add(f2).toString());
    assertEquals(new Fraction(-7,45).toString(), f2.add(f3).toString());
    assertEquals(new Fraction(43,36).toString(), f3.add(f4).toString());
    assertEquals(new Fraction(7,4).toString(), f4.add(f5).toString());
    assertEquals(new Fraction(-10,3).toString(), f5.add(f1).toString());

    //Subtraction Tests
    assertEquals(new Fraction(-56,15).toString(), f1.subtract(f2).toString());
    assertEquals(new Fraction(43,45).toString(), f2.subtract(f3).toString());
    assertEquals(new Fraction(-83,36).toString(), f3.subtract(f4).toString());
    assertEquals(new Fraction(7,4).toString(), f4.subtract(f5).toString());
    assertEquals(new Fraction(10,3).toString(), f5.subtract(f1).toString());

    //Division Tests
    assertEquals(new Fraction(-25,3).toString(), f1.divide(f2).toString());
    assertEquals(new Fraction(-18,25).toString(), f2.divide(f3).toString());
    assertEquals(new Fraction(-20,63).toString(), f3.divide(f4).toString());
    assertEquals(new Fraction(0,1).toString(), f5.divide(f1).toString());

    //Multiplication Tests
    assertEquals(new Fraction(-4,3).toString(), f1.multiply(f2).toString());
    assertEquals(new Fraction(-2,9).toString(), f2.multiply(f3).toString());
    assertEquals(new Fraction(-35,36).toString(), f3.multiply(f4).toString());
    assertEquals(new Fraction(0,1).toString(), f4.multiply(f5).toString());
    assertEquals(new Fraction(0,1).toString(), f5.multiply(f1).toString());
    
    //Exponential Tests
    assertEquals(new Fraction(9,100).toString(), f1.pow(-2).toString());
    assertEquals(new Fraction(5,2).toString(), f2.pow(-1).toString());
    assertEquals(new Fraction(1,1).toString(), f3.pow(0).toString());
    assertEquals(new Fraction(7,4).toString(), f4.pow(1).toString());
    assertEquals(new Fraction(0,1).toString(), f5.pow(2).toString());

    //String Constructor to Fraction
    assertEquals(new Fraction(1,2).toString(), new Fraction("1/2").toString());
    assertEquals(new Fraction(-1,2).toString(), new Fraction("-1/2").toString());
    assertEquals(new Fraction(-1,2).toString(), new Fraction("1/-2").toString());
    assertEquals(new Fraction(1,2).toString(), new Fraction("-1/-2").toString());
    assertEquals(new Fraction(17,1).toString(), new Fraction("17").toString());
    assertEquals(new Fraction(-17,1).toString(), new Fraction("-17").toString());
    assertEquals(new Fraction(1,3).toString(), new Fraction("6/18").toString());
    assertEquals(new Fraction(-1,3).toString(), new Fraction("-6/18").toString());
    assertEquals(new Fraction(-1,3).toString(), new Fraction("6/-18").toString());
    assertEquals(new Fraction(1,3).toString(), new Fraction("-6/-18").toString());
    assertEquals(new Fraction(3,1).toString(), new Fraction("18/6").toString());
    assertEquals(new Fraction(3,-1).toString(), new Fraction("-18/6").toString());
    assertEquals(new Fraction(-3,1).toString(), new Fraction("18/-6").toString());
    assertEquals(new Fraction(3,1).toString(), new Fraction("-18/-6").toString());
  }

}
