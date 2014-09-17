package edu.grinnell.csc207.chenzhi17.utils;

import java.util.Arrays;
import java.util.ArrayList;

public class OtherStringUtils {

	public static String [] splitCSV(String str){
		
		/*variables for the method:boolean switches and index*/
		
		int index = 0;
		int splitIndex = 0;
		Boolean containsQuote = Boolean.FALSE ;
		String [] tempStore; //for temporary storage
		ArrayList<String> items = new ArrayList<String>(); //collect Strings 
		
		/* check if any character is a quote character */
		for( index = 0 ; index < str.length(); index++){
			//if character at index is a quote character
			if (str.charAt(index) == '\"'){
				containsQuote = Boolean.TRUE;
				splitIndex = index;
				System.out.println(index);
				break;
			}
			System.out.println("break?");
		}

		if (!containsQuote){
			return str.split(",");
		} //if: quote character not found
		else {
			//start grouping items 
			tempStore =  str.substring(0, index).split(",");
		}// else : quote character found
		
		return str.split("\"");
		}
	
	public static String [] recurSplit(String name){
		
		return name.split(" ");
	}
	
	public static void main(String[] args) {
		String [] resultString;
		resultString = OtherStringUtils.splitCSV("a,\"b,b\"\"\",c");
		System.out.println(Arrays.toString(resultString));
	}

}
