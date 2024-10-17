package com.zoho.stringtaskutility;
import java.util.*;
import com.zoho.invalidinputexception.*;
public class StringTaskUtility{
	public static void isNullString(String str) throws InvalidInputException{
		if(str==null){
			throw new InvalidInputException("Invalid input : null string ");
			}
		}
	public static void isInvalidString(String str) throws InvalidInputException{
		if(str==null){
			throw new InvalidInputException("Invalid input : null string");
			}
		if(str.isEmpty()){
			throw new InvalidInputException("Invalid input : Empty string");
			}
			}
	public static void exceedsMaxNoOfChar(int index,String str) throws InvalidInputException{
		isInvalidString(str);
		if(index<0||index>str.length()){
			throw new InvalidInputException("Invalid No of char");
		}
		}
	public static void isInvalidIndex(int index,String str) throws InvalidInputException{
		isInvalidString(str);
		if(index<0||index>=str.length()){
			throw new InvalidInputException("Invalid Index");
		}
		}
	public static boolean isInvalidList(List<String> list){
		if (list == null||list.isEmpty()) {
            		return true;
       	 }
       	 for (String element : list){
            		if (element != null) {
               		 return false;
            		}
        	}
        	return true; 
		}
		}
