package edu.grinnell.csc207.chenzhi17.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author chenzhi17
 *
 */
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
  }//splitAt(String input, char delimiter)

  public static String[] splitCSV(String input)
  {

    /* Storage objects */
    StringBuffer elementHolder = new StringBuffer(); // hold items temporarily during split                                         
    LinkedList<String> finalArray = new LinkedList<String>(); // store final strings from splitting

    /**
     * Variables used in the splitting process 
     * 
     * specialCommaZone        : TRUE when commas should be ignored during splitting
     *                           FALSE when commas should be not be ignored during splitting
     *                           preset to FALSE
     *                    
     * charIndex and nextIndex : counters for the iteration
     * currentChar and nextChar: denotes current and next characters during iteration
     */

    Boolean specialCommaZone = Boolean.FALSE;
    int strLength = input.length();
    int charIndex = 0;
    int nextIndex = 0;
    char quote = '\"';
    char comma = ',';
    char currentChar;
    char nextChar;

    /* Split the input string based on CSV splitting rules */
    for (charIndex = 0; charIndex < strLength; charIndex++)
      {

        // check if nextIndex is within string,input
        if (charIndex + 1 < strLength)
          {
            nextIndex = charIndex + 1; // increment counter
          }

        // get current and next character
        currentChar = input.charAt(charIndex);
        nextChar = input.charAt(nextIndex);

        if ((currentChar == comma) && (!specialCommaZone))
          {
            finalArray.add(elementHolder.toString()); // add buffer contents to final array storage
            elementHolder.delete(0, elementHolder.length()); //clean up buffer
          }
        else if ((currentChar == comma) && (specialCommaZone))
          {
            elementHolder.append(comma); //add to buffer 
          }
        else if ((currentChar == quote) && (nextChar == quote))
          {
            elementHolder.append(quote);
            charIndex++; //move on to next char 
          }
        else if ((currentChar == quote) && (nextChar != quote)
                 && (nextChar != comma) && (!specialCommaZone))
          {
            specialCommaZone = Boolean.TRUE; //turn on specialCommaZone signal
          }
        else if ((currentChar == quote) && (nextChar != quote)
                 && (nextChar != comma) && (specialCommaZone))
          {
            specialCommaZone = Boolean.FALSE; //turn off special CommaZone signal
          }
        else if ((currentChar == comma) && (nextChar == quote)
                 && (!specialCommaZone))
          {
            specialCommaZone = Boolean.TRUE; //turn on specialCommaZone signal
          }
        else if ((currentChar == comma) && (nextChar == quote)
                 && (specialCommaZone))
          {
            specialCommaZone = Boolean.FALSE; //turn off special CommaZone signal
          }
        else if ((currentChar == quote) && (nextChar == comma)
                 && (specialCommaZone))
          {
            specialCommaZone = Boolean.FALSE; //turn off special CommaZone signal
          }
        else if ((currentChar == quote) && (nextChar == comma)
                 && (!specialCommaZone))
          {
            specialCommaZone = Boolean.TRUE; //turn on specialCommaZone signal
          }
        else
          {
            elementHolder.append(currentChar); //adding a character to the element holder
          }
      }//for loop

    finalArray.add(elementHolder.toString()); //stores the last element of the input array to the element holder

    return finalArray.toArray(new String[finalArray.size()]); // convert linkedList to String[] and return
  } // splitCSV(String input)

}