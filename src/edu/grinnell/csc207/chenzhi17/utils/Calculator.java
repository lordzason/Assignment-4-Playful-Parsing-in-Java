package edu.grinnell.csc207.chenzhi17.utils;

import java.math.BigInteger;

public class Calculator
{
  public static BigInteger eval0(String input)
  {
    String[] result = StringUtils.splitAt(input, ' ');

    BigInteger answer = BigInteger.valueOf(Long.valueOf(result[0]));

    int resultIndex;

    //Testing Purposes
    /*
    for (int i = 0; i < result.length; i++)
      {
        System.out.println("result[" + i + "]=" + result[i]);
      }
    System.out.println("answer=" + answer);
    */

    for (int i = 0; i < result.length; i++)
      {
        resultIndex = i;

        if (result[i].equals("+"))
          {
            answer =
                answer.add(BigInteger.valueOf(Long.valueOf(result[resultIndex + 1])));
          }
        else if (result[i].equals("-"))
          {
            answer =
                answer.subtract(BigInteger.valueOf(Long.valueOf(result[resultIndex + 1])));
          }
        else if (result[i].equals("*"))
          {
            answer =
                answer.multiply(BigInteger.valueOf(Long.valueOf(result[resultIndex + 1])));
          }
        else if (result[i].equals("/"))
          {
            answer =
                answer.divide(BigInteger.valueOf(Long.valueOf(result[resultIndex + 1])));
          }
        else if (result[i].equals("^"))
          {
            answer = answer.pow(Integer.valueOf(result[resultIndex + 1]));
          }
      }

    //Testing Purposes
    /*
    System.out.println("Answer is " + answer);
    */

    return answer;
  }

}
