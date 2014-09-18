package edu.grinnell.csc207.chenzhi17.utils;

import java.math.BigInteger;

public class Calculator
{
  public static BigInteger eval0(String input)
  {
    //An array to hold elements after separation with a delimiter
    String[] result = StringUtils.splitAt(input, ' ');

    //answer is the first element and will be updated by the calculator
    BigInteger answer = BigInteger.valueOf(Long.valueOf(result[0]));

    for (int i = 0; i < result.length; i++)
      {

        /*
         * Running through the result array, if an operation is reached,
         * one of the if statements will be called 
         * and the proper operation will be carried out.
         */
        if (result[i].equals("+"))
          {
            answer =
                answer.add(BigInteger.valueOf(Long.valueOf(result[i + 1])));
          }
        else if (result[i].equals("-"))
          {
            answer =
                answer.subtract(BigInteger.valueOf(Long.valueOf(result[i + 1])));
          }
        else if (result[i].equals("*"))
          {
            answer =
                answer.multiply(BigInteger.valueOf(Long.valueOf(result[i + 1])));
          }
        else if (result[i].equals("/"))
          {
            answer =
                answer.divide(BigInteger.valueOf(Long.valueOf(result[i + 1])));
          }
        else if (result[i].equals("^"))
          {
            answer = answer.pow(Integer.valueOf(result[i + 1]));
          }
      }

    return answer;
  }

  public static Fraction eval1(String input)
  {
    //An array to hold the elements after separation with a delimiter
    String[] result = StringUtils.splitAt(input, ' ');

    //answer is the first element and will be updated by the calculator
    Fraction answer = new Fraction(result[0]);

    /*
     * Going through the result array,
     * if an operation is reached,
     * one of the if statements will be called
     * and the proper operation with fractions
     * will be carried out.
     */
    for (int i = 0; i < result.length; i++)
      {
        if (result[i].equals("+"))
          {
            Fraction second = new Fraction(result[i + 1]);
            answer = answer.add(second);
          }
        else if (result[i].equals("-"))
          {
            Fraction second = new Fraction(result[i + 1]);
            answer = answer.subtract(second);
          }
        else if (result[i].equals("*"))
          {
            Fraction second = new Fraction(result[i + 1]);
            answer = answer.multiply(second);
          }
        else if (result[i].equals("/"))
          {
            Fraction second = new Fraction(result[i + 1]);
            answer = answer.divide(second);
          }
        else if (result[i].equals("^"))
          {
            answer = answer.pow(Integer.valueOf(result[i + 1]));
          }
      }

    return answer;
  }

}
