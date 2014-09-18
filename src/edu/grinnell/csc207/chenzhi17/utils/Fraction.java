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
  
  /** Fractions that are negative will have the negative sign in the numerator **/

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
    simplifyFraction(num, denom);

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

    simplifyFraction(top, bottom);

  } // Fraction(int, int)

  public void simplifyFraction(BigInteger top, BigInteger bottom)
  {
    // when 'num' and 'denom' are both negative find abs() of 'num' and 'denom'
    if ((top.compareTo(BigInteger.ZERO) == -1)
        && (bottom.compareTo(BigInteger.ZERO) == -1))
      {
        top = top.abs();
        bottom = bottom.abs();
      }
    else if ((top.compareTo(BigInteger.ZERO) != -1)
             && (bottom.compareTo(BigInteger.ZERO) == -1))
    //if the denominator is negative and the numerator is positive, the numerator becomes positive
    //and the denominator becomes positive
      {
        top = top.multiply(BigInteger.valueOf(-1));
        bottom = bottom.abs();
      }

    BigInteger gCD = top.gcd(bottom); // greatest common denominator

    // simplify with greatest common denominator
    this.num = top.divide(gCD);
    this.denom = bottom.divide(gCD);
  }

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

        BigInteger top = (BigInteger.valueOf(numerator));
        BigInteger bottom = (BigInteger.valueOf(denominator));

        simplifyFraction(top, bottom);
      }

  } // Fraction(String)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Uses remainder to find the fractional part of a mixed fraction
   * @param none
   * @return a fraction that is the fractional part 
   */
  public Fraction fractional()
  {
    BigInteger remainder;

    remainder = this.num.remainder(this.denom);

    return new Fraction(remainder, this.denom);
    
  }//Fraction fractional()

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

  /**
   * Subtract another fraction from our current fraction object
   * @param subtrahend
   * @return difference between our current fraction object and 'subtrahend'
   */
  public Fraction subtract(Fraction subtrahend)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultDenominator = this.denom.multiply(subtrahend.denom);
    resultNumerator =
        (this.num.multiply(subtrahend.denom)).subtract(subtrahend.num.multiply(this.denom));

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
      }
    else if (numInt < 0 && denomInt < 0)
      {
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

} // class Fraction

