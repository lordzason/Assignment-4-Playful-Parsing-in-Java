package edu.grinnell.csc207.chenzhi17.utils;

import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Albert and Zhi, and our respective previous partners
 * @author CSC152 2005S
 * @version 1.0 of February 2005
 */

/*
 * Gratitude to Sam Rebelsky for his assistance on resolving the return type in main
 * and in showing us how to create a project
 */

public class Fraction
{
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented with a negative numerator. Similarly, if a fraction has a
   * negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a
   * fraction in simplified form, one must call the simplify method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(BigInteger num, BigInteger denom)
  {
    // when 'num' and 'denom' are both negative find abs() of 'num' and 'denom'
    if ((num.compareTo(BigInteger.ZERO) == -1)
        && (denom.compareTo(BigInteger.ZERO) == -1))
      {
        num = num.abs();
        denom = denom.abs();
      }

    BigInteger gCD = num.gcd(denom);
    //if both num and denom are negative negate gcd before dividing

    this.num = num.divide(gCD);
    this.denom = denom.divide(gCD);

  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(int num, int denom)
  {
    BigInteger top = (BigInteger.valueOf(num));
    BigInteger bottom = (BigInteger.valueOf(denom));
    BigInteger gCD = top.gcd(bottom); // greatest common denominator

    // simplify with greatest common denominator
    this.num = top.divide(gCD);
    this.denom = bottom.divide(gCD);

  } // Fraction(int, int)

  /**
   * Turns a fraction in a string into its numerical form
   */
  public Fraction(String str)
  {
    //temporary variables
    int numerator;
    int denominator;
    String splitResults[] = str.split("/");

    // check if string is a whole fraction
    if (splitResults[0].compareTo(str) == 0)
      {
        numerator = Integer.parseInt(str);
        this.num = BigInteger.valueOf(numerator);
        this.denom = BigInteger.valueOf(1);
      }
    else
      //if not whole fraction
      {
        numerator = Integer.parseInt(splitResults[0]);
        denominator = Integer.parseInt(splitResults[1]);
        this.num = BigInteger.valueOf(numerator);
        this.denom = BigInteger.valueOf(denominator);
      }

  } // Fraction(String)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   *  Multiplies two fractions. The current object fraction and another fraction
   * @param multiplyMe the fraction to be multiplied with our current fraction
   * @return a fraction that is a product of current object fraction and 'multiplyMe'
   */
  public Fraction multiply(Fraction multiplyMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = (this.num.multiply(multiplyMe.num));
    resultDenominator = this.denom.multiply(multiplyMe.denom);

    return new Fraction(resultNumerator, resultDenominator);
  }// multiply(Fraction)

  /**
   * Divides two fractions. The current object fraction and another fraction
   * @param divideMe the fraction our current fraction divides by.
   * @return a fraction that is the quotient of our current object fraction and 'divideMe'
   */
  public Fraction divide(Fraction divideMe)
  {

    BigInteger divideMeNum = divideMe.denom;
    BigInteger divideMeDenom = divideMe.num;

    BigInteger resultNumerator = (this.num.multiply(divideMeNum));
    BigInteger resultDenominator = this.denom.multiply(divideMeDenom);

    return new Fraction(resultNumerator, resultDenominator);
  }// divide(Fraction)

  /**
  * Express current fraction object as a double.
  * @param none
  * @return the double equivalent to this fraction
  */
  public double doubleValue()
  {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction addMe to this fraction.
   * @param addMe  the fraction to be added to our current fraction
   * @return the sum of our current fraction object and 'addMe'
   */
  public Fraction add(Fraction addMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  //NEEDS TO BE FIXED
  /**
   * Subtract another fraction from our current fraction object
   * @param subtrahend
   * @return difference between our current fraction object and 'subtrahend'
   */
  public Fraction subtract(Fraction subtrahend)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    BigInteger righttop;
    BigInteger lefttop;

    // The denominator of the result is the
    // product of this object's denominator
    // and subtrahend's denominator

    //System.out.println("this.num = " + this.num);
    resultDenominator = this.denom.multiply(subtrahend.denom);
    //System.out.println("this.num = " + this.num);
    //System.out.println("resultDenominator:" + resultDenominator);
    // The numerator is more complicated

    lefttop = (this.num.multiply(subtrahend.denom));
    //System.out.println(this.num);
    righttop = (subtrahend.num.multiply(this.denom));
    //System.out.println("lefttop:" + lefttop + " righttop" + righttop);

    resultNumerator =
        (this.num.multiply(subtrahend.denom)).subtract(subtrahend.num.multiply(this.denom));
    //System.out.println("resultNumerator:" + resultNumerator);

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// subtract(Fraction)

  /**
   * finds the additive inverse of our current object
   * @param none
   * @return  fraction, the negation of our current fraction
   */
  public Fraction negate()
  {
    // store fraction's numerator and denominator
    BigInteger numerator = this.num;
    BigInteger denominator = this.denom;

    // 'int' form of numerator and denominator for comparison
    int numInt = numerator.intValue();
    int denomInt = denominator.intValue();

    // Negate the fraction with different mechanisms depending on the 
    // original state of the fraction

    if (numInt > 0 && denomInt > 0)
      {
        numerator = numerator.negate();
        denominator = denominator.negate();
      }
    else if (numInt < 0 && denomInt < 0)
      {
        numerator = denominator.negate();
        denominator = denominator.negate();
      }
    else if (numInt < 0 && denomInt > 0)
      {
        numerator = numerator.negate();
      }
    else if (numInt > 0 && denomInt < 0)
      {
        denominator = denominator.negate();
      }

    return new Fraction(numerator, denominator);
  }//negate()

  /**
   * Returns the new fraction that results from raising the given fraction 
   * to the given exponent, which may be positive, negative, 
   * or zero.
   * @param expt the exponent to raise the fraction to
   * @return fraction raised to the power, pow
   */
  public Fraction pow(int expt)
  {
    BigInteger numerator;
    BigInteger denominator;

    // different mechanisms of raising the fraction according 
    // to the sign of exponent
    if (expt < 0)
      {
        int newExpt = Math.abs(expt);
        numerator = this.denom.pow(newExpt);
        denominator = this.num.pow(newExpt);
      }
    else if (expt == 0)
      {
        numerator = BigInteger.valueOf(1);
        denominator = BigInteger.valueOf(1);
      }
    else
      {
        numerator = this.num.pow(expt);
        denominator = this.denom.pow(expt);
      }

    return new Fraction(numerator, denominator);
  }

  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO))
      {
        return "0";
      } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  public static void main(String[] args)
    throws Exception
  {
    /*
    Fraction f1;
    f1 = new Fraction(-10, 3);
    Fraction f2;
    f2 = new Fraction(2, 5);
    Fraction f3;
    f3 = new Fraction(5, -9);
    */

    /*   System.out.println();
       System.out.println(f1);
       System.out.println();

       System.out.println(f1.negate());
       System.out.println(f2.negate());
       System.out.println(f3.negate());

       System.out.println();

       System.out.println("Subtract needs to be fixed.");
       System.out.println(f1.subtract(f2));
       System.out.println(f2.subtract(f3));
       System.out.println(f3.subtract(f1));
       System.out.println("Subtract needs to be fixed.");

       System.out.println();

       BigInteger a = BigInteger.valueOf(-2);
       BigInteger b = BigInteger.valueOf(3);
       System.out.println(a.subtract(b));

       System.out.println();

       System.out.println(f1.divide(f2));
       System.out.println(f2.divide(f3));
       System.out.println(f3.divide(f1));
       System.out.println();

       System.out.println("String Constructor to Fraction");
       Fraction fr1;
       fr1 = new Fraction("1/2");
       System.out.println("fr1 = " + fr1);
       Fraction fr2;
       fr2 = new Fraction("17");
       System.out.println("fr2 = " + fr2);
       Fraction fr3;
       fr3 = new Fraction("-1/2");
       System.out.println("fr3 = " + fr3);
       Fraction fr4;
       fr4 = new Fraction("1/-2");
       System.out.println("fr4 = " + fr4);
       Fraction fr5;
       fr5 = new Fraction("-1/2");
       System.out.println("fr5 = " + fr5);
       Fraction fr6;
       fr6 = new Fraction("-1/-2");
       System.out.println("fr6 = " + fr6);
       Fraction fr7;
       fr7 = new Fraction("-17");
       System.out.println("fr7 = " + fr7);

       System.out.println();

       System.out.println("Exponent");
       System.out.println(f1.pow(2));
       System.out.println(f2.pow(-3));
       System.out.println(f3.pow(0));
       */
    //System.out.println(f1.negate());
    //System.out.println(f2.negate());
    //System.out.println(f3.negate());

  }//main()

} // class Fraction

