package edu.grinnell.csc207.chenzhi17.utils;

import java.math.BigInteger;

public class Calculator
{

  public static BigInteger eval0(String input)
  {
    String[] result = StringUtils.splitAt(input, ' ');
    
    BigInteger answer = BigInteger.valueOf(Integer.valueOf(result[0]));
    
    System.out.println(result);
    
    int resultIndex;

    for (int i = 0; i < result.length; i++)
      {
        resultIndex = i;
        
        if(result[i] == "+")
          {
            answer = answer.add(BigInteger.valueOf(Integer.valueOf(result[resultIndex + 1])));
          }
        else if(result[i] == "-")
          {
            answer = answer.subtract(BigInteger.valueOf(Integer.valueOf(result[resultIndex + 1])));
          }
        else if(result[i] == "*")
          {
            answer = answer.multiply(BigInteger.valueOf(Integer.valueOf(result[resultIndex + 1])));
          }
        else if(result[i] == "/")
          {
            answer = answer.divide(BigInteger.valueOf(Integer.valueOf(result[resultIndex + 1])));
          }
        else if(result[i] == "^")
          {
            answer = answer.pow(Integer.valueOf(result[resultIndex + 1]));
          }
      }
    
    System.out.println("Answer is " + answer);
    
    return answer;
  }

  public static int main(String[] args)
  {
    eval0("1 + 2 * 3");

    return 0;
  }

}
