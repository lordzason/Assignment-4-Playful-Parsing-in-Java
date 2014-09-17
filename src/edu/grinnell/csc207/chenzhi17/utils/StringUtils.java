package edu.grinnell.csc207.chenzhi17.utils;

//import java.util.Arrays;

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

    System.out.println("CSV test begin:");

    int commaCount = 0;
    Boolean specialCommaZone = Boolean.FALSE;

    //Count the number of commas not within double quotation marks
    //to determine the number of items after a CSV split
    for (int inputCharIndex = 0; inputCharIndex < input.length(); inputCharIndex++)
      {
        if ((specialCommaZone.equals(Boolean.FALSE))
            && (input.charAt(inputCharIndex) == ','))
          {
            commaCount++;
          }
        else if ((specialCommaZone.equals(Boolean.FALSE))
                 && (input.charAt(inputCharIndex) == '"'))
          {
            specialCommaZone = Boolean.TRUE;
          }
        else if ((specialCommaZone.equals(Boolean.TRUE))
                 && (input.charAt(inputCharIndex) == '"'))
          {
            specialCommaZone = Boolean.FALSE;
          }
      }

    //A string buffer to hold items during a CSV split
    StringBuffer elementHolder = new StringBuffer(input.length() + 1);

    //An array to hold items after CSV split
    String[] strArray = new String[commaCount + 1];
    int strArrayIndex = 0;

    //Splitting the input string based on CSV splitting rules
    for (int charIndex = 0; charIndex < input.length(); charIndex++)
      {
        if ((input.charAt(charIndex) == ',')
            && (specialCommaZone.equals(Boolean.FALSE)))
          {
            //System.out.println("Here3!" + elementHolder.toString());
            strArray[strArrayIndex] = elementHolder.toString();
            System.out.println("strArray[" + strArrayIndex + "]="
                               + strArray[strArrayIndex]);
            strArrayIndex++;
            elementHolder.delete(0, elementHolder.length());
          }
        else if ((input.charAt(charIndex) == ',')
                 && (specialCommaZone.equals(Boolean.TRUE)))
          {
            //System.out.println("Here!" + elementHolder.toString());
            elementHolder.append(',');
            //System.out.println("Here2!" + elementHolder.toString());
          }
        else if ((input.charAt(charIndex) == '\"')
                 && (input.charAt(charIndex + 1) == '\"'))
          {
            elementHolder.append('"');
            charIndex++;
          }
        else if ((input.charAt(charIndex) == '\"')
                 && (input.charAt(charIndex + 1) != '\"')
                 && (input.charAt(charIndex + 1) != ',')
                 && (specialCommaZone.equals(Boolean.FALSE)))
          {
            specialCommaZone = Boolean.TRUE;
          }
        else if ((input.charAt(charIndex) == '\"')
                 && (input.charAt(charIndex + 1) != '\"')
                 && (input.charAt(charIndex + 1) != ',')
                 && (specialCommaZone.equals(Boolean.TRUE)))
          {
            specialCommaZone = Boolean.FALSE;
          }
        else if ((input.charAt(charIndex) == ',')
                 && (input.charAt(charIndex + 1) == '\"')
                 && (specialCommaZone.equals(Boolean.FALSE)))
          {
            specialCommaZone = Boolean.TRUE;
          }
        else if ((input.charAt(charIndex) == ',')
                 && (input.charAt(charIndex + 1) == '\"')
                 && (specialCommaZone.equals(Boolean.TRUE)))
          {
            specialCommaZone = Boolean.FALSE;
          }
        else if ((input.charAt(charIndex) == '\"')
                 && (input.charAt(charIndex + 1) == ',')
                 && (specialCommaZone.equals(Boolean.TRUE)))
          {
            specialCommaZone = Boolean.FALSE;
          }
        else if ((input.charAt(charIndex) == '\"')
                 && (input.charAt(charIndex + 1) == ',')
                 && (specialCommaZone.equals(Boolean.FALSE)))
          {
            specialCommaZone = Boolean.TRUE;
          }
        else
          {
            elementHolder.append(input.charAt(charIndex));
            //System.out.println(elementHolder.toString());
          }
      }

    strArray[strArrayIndex] = elementHolder.toString();
    System.out.println("strArray[" + strArrayIndex + "]="
                       + strArray[strArrayIndex]);

    System.out.println("CSV test end.");

    return strArray;
  }//splitCSV(String input)
}