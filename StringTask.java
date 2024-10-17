package com.zoho.task;
import java.util.*;
import com.zoho.invalidinputexception.*;
import com.zoho.stringtaskutility.*;
import java.util.regex.Pattern;
public class StringTask{
	public int getLength(String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		return str.length();
		}
	public char[] convertToArr(String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		return str.toCharArray();
		}
	public char getCharacterAt(String str,int index) throws InvalidInputException{
		StringTaskUtility.isInvalidString(str);
		StringTaskUtility.isInvalidIndex(index,str);
		return str.charAt(index);
		}
	public int getNoOfOccurences(char character,String str) throws InvalidInputException{
		StringTaskUtility.isInvalidString(str);
		int noOfOcc=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==character)
				noOfOcc++;
				}
		return noOfOcc;
	}
	public int getGreatestPosition(char character,String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		return  str.lastIndexOf(character);
		}
	public String getLastFewCharacters(int noOfChar,String str) throws InvalidInputException{
		StringTaskUtility.isInvalidString(str);
		StringTaskUtility.exceedsMaxNoOfChar(noOfChar,str);
		return str.substring(str.length() - noOfChar);
	}
	public String getFirstFewCharacters(int noOfChar,String str) throws InvalidInputException{
		StringTaskUtility.isInvalidString(str);
		StringTaskUtility.exceedsMaxNoOfChar(noOfChar,str);
		return str.substring(0, noOfChar);
			}
	public String toReplacePartOfString(String replacement,String originalString,String type,int index) throws InvalidInputException{
		StringTaskUtility.isInvalidString(originalString);
		StringTaskUtility.isInvalidString(replacement);
		StringTaskUtility.isInvalidString(type);
		String result="";
		switch(type.toLowerCase()){
			case "prefix":{
				result = (replacement.length() >= originalString.length())?    replacement:replacement+originalString.substring(replacement.length());
                		break;
   			}
   			case "suffix":{
   				result = (replacement.length() >= originalString.length())? replacement:originalString.substring(0, originalString.length() - replacement.length()) + replacement;
                		break;
                	}
                	case "any" :{
                		StringTaskUtility.isInvalidIndex(index,originalString);
                		String prefix = originalString.substring(0, index);
                		String suffix = originalString.substring(index);
                		result = (replacement.length()>suffix.length())? prefix + replacement:prefix + replacement + suffix.substring(replacement.length());
                		break;
                	}
                	default :{
                		throw new InvalidInputException("Invalid type. Use 'prefix', 'suffix', or 'any'.");
                		}
                	
   		}
   		return result;
   		}
   				
	public boolean endWith(String ends,String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		StringTaskUtility.isNullString(ends);
		return str.endsWith(ends)? true:false;
		}
	public boolean startWith(String starts,String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		StringTaskUtility.isNullString(starts);
		return str.startsWith(starts)? true:false;
		}
	public String convertToUpperCase(String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		return str.toUpperCase();
		}
	public String convertToLowerCase(String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		return str.toLowerCase();
		}
	public String toReverse(String str) throws InvalidInputException{
		StringTaskUtility.isInvalidString(str);
		char[] charArray = str.toCharArray();
        	int left = 0;
        	int right = charArray.length - 1;
        	while (left < right) {
            		char temp = charArray[left];
            		charArray[left] = charArray[right];
            		charArray[right] = temp;
            		left++;
            		right--;
            		}
            	return new String(charArray);
		 }
	public String toRemoveSpaces(String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		return str.replace(" ", "");
		}
	public String[] convertToStringArr(String seperator,String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		StringTaskUtility.isNullString(seperator);
		String regexSeperator=Pattern.quote(seperator);
		return  str.split(regexSeperator);
		}
	public boolean compareStringIncludeCase(String firstString,String secondString) throws InvalidInputException{
		StringTaskUtility.isNullString(firstString);
		StringTaskUtility.isNullString(secondString);
		return firstString.equals(secondString);
		}
	public boolean compareStringExcludeCase(String firstString,String secondString) throws InvalidInputException{
		StringTaskUtility.isNullString(firstString);
		StringTaskUtility.isNullString(secondString);
		return firstString.equalsIgnoreCase(secondString);
		}
	public String trimSpacesAtBeginAndEnd(String str) throws InvalidInputException{
		StringTaskUtility.isNullString(str);
		return str.trim();
		}
	public String toMergeStrings(List<String> stringList,String mergingChar) throws InvalidInputException{
		StringTaskUtility.isNullString(mergingChar);
		boolean invalidList=StringTaskUtility.isInvalidList(stringList);
		if(invalidList){
			throw new InvalidInputException("Invalid list");
			}
		return String.join(mergingChar, stringList);
	}
		

}
