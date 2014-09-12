package edu.grinnell.csc207.chenzhi17.utils;

//import java.util.Arrays;

public class StringUtils
{

  /**
   * This method splits a given string using a constant delimiter
   * @param input The String to split
   * @param delimiter The character of which splitting is based on
   * @return an array of strings elements representing the splits of input
   * preconditions:
   * postconditions:
   */
  public static String[] splitAt(String input, char delimiter)
  {

    // look through the String character by character till the length of the string
    //until you find the delimiter
    // when delimiter found use the substring method to form a
    // a string of what you have so far and store it in a temporal string
    // add this string as an elemnent of you string to return

    int index;
    int strArrayIndex;
    int beginIndex = 0;
    int delimiterCount = 0;
    int locationIndex = 0;
    int delimiterLocationIndex = 0;

    //Determine the number of delimiters
    for (index = 0; index < input.length(); index++)
      {
        if (input.charAt(index) == delimiter)
          {
            delimiterCount++;
          }
      }

    //Create an array to hold values after splitting
    String[] strArray = new String[delimiterCount + 1];

    //Create an array to hold locations of delimiters
    int[] delimiterLocations = new int[delimiterCount];

    //Determine the location of delimiters
    for (index = 0; index < input.length(); index++)
      {
        if (input.charAt(index) == delimiter)
          {
            delimiterLocations[locationIndex] = index;
            /*
             //Comments for testing
            System.out.println("delimiterLocations[" + 
            locationIndex + "]=" + index);
            */
            locationIndex++;
          }
      }

    //Split based on location of delimiters
    for (strArrayIndex = 0; strArrayIndex < delimiterCount; strArrayIndex++)
      {
        strArray[strArrayIndex] =
            input.substring(beginIndex,
                            delimiterLocations[delimiterLocationIndex]);
        /*
         //Comments for testing
         System.out.println("strArray[" + strArrayIndex + "]=" 
        + input.substring(beginIndex,delimiterLocations[delimiterLocationIndex]));
        */
        beginIndex = delimiterLocations[delimiterLocationIndex] + 1;
        delimiterLocationIndex++;
      }

    //Comments for testing
    /*
    System.out.println(delimiterLocationIndex);
    System.out.println(beginIndex);
    */

    //Gets last segment
    strArray[strArrayIndex] = input.substring(beginIndex, input.length());

    return strArray;
  }

}