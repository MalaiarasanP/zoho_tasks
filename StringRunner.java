package com.zoho.runner;
import java.util.*;
import java.io.*;
import com.zoho.task.*;
import com.zoho.invalidinputexception.*;

public class StringRunner{
public static void main(String[] args){
	System.out.println("=== Retrieve a string from command line arguments ===");
	if(args.length>0){
		System.out.println("You entered : "+ args[0]);
		}
	else{
		System.out.println("No input was provided\n");
		}
	System.out.println("=========== String Tasks =============");
	System.out.print("1.Length of the String\n2.Convert String into char array\n3.Displaying a character of a string\n4.No. of occurence of character\n5.Greatest position of a character\n6.Displaying last Few characters of a string\n7.Displaying first few characters of a string\n8.Replacing characters in a string\n9.check whether the string starts with the original string \n10.check whether the string ends with the original string\n11.UPPERCASE\n12.lowercase\n13.Reverse a string\n14.Multiple words in a single line\n15.Convert a string into string array using a seperator\n16.Comparing strings\n17.Removing extra spaces in the beginning and the end\n18.Merging strings with a character in between\n19.Exit\n");
	System.out.println("======================================");
	boolean exit;
	int selectOperation;
	String str="";
	Scanner scanner = new Scanner(System.in);
	StringTask word = new StringTask();
	do{
	exit = true;
	selectOperation=getValidIntegerInput(scanner,"Select an operation : ");
	if(0<selectOperation&&selectOperation<20){
		exit = false;
		}
	else{
		System.out.println("Please enter a number between (1-19)");
		}
	
	}while(exit);
	
	do{	
	exit=false;
	try{
	switch(selectOperation){
	case 1:{
	System.out.println("=== String length ===");
	str = getValidInputString(scanner,"Enter a String : ");
	System.out.println("Length of the entered String : " + word.getLength(str));
	break;
	}
	case 2:{
	System.out.println("=== String -> Character Array ===");
	str = getValidInputString(scanner,"Enter a String : ");
	System.out.println("Converting String into char Array : "+ Arrays.toString(word.convertToArr(str)));
	break;
	}
	case 3:{
	System.out.println("=== Character of a string ===");
	str = getValidInputString(scanner,"Enter a String : ");
	int indexNo = getValidIntegerInput(scanner,"Enter index Number : ");
	System.out.println(indexNo + "Character of the String : "+ word.getCharacterAt(str,indexNo));
	break;
	}
	case 4:{
	System.out.println("=== No. of occurence ===");
	str = getValidInputString(scanner,"Enter a String : ");
	System.out.print("Enter a char to check its no. of occurrences : ");
	char character1 = scanner.next().charAt(0);
	System.out.println("No of occurence of the entered character :"+ word.getNoOfOccurences(character1,str));
	break;
	}
	case 5:{
	System.out.println("=== Greatest position of a Character ===");
	str = getValidInputString(scanner,"Enter a String : ");
	System.out.print("Enter a char to find its greatest position : ");
	char character2 = scanner.next().charAt(0);
	if(word.getGreatestPosition(character2,str)==-1){
		System.out.println("The entered character is not present in the string");
		}
	else{
		System.out.println("Greatest position of the entered character :"+ word.getGreatestPosition(character2,str));
	}
	break;
	}
	case 6:{
	System.out.println("=== Displaying last few characters ===");
	str = getValidInputString(scanner,"Enter a String : ");
	int noOfLastFewChar = getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
	String lastFewChar = word.getLastFewCharacters(noOfLastFewChar,str);
	System.out.println("Last " + noOfLastFewChar+" characters of the given string : "+ lastFewChar);	
	break;
	}
	case 7:{
	System.out.println("=== Displaying first few characters ===");
	str = getValidInputString(scanner,"Enter a String : ");
	int noOfFirstFewChar= getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
	String firstFewChar = word.getFirstFewCharacters(noOfFirstFewChar,str);	
	System.out.println("First "+noOfFirstFewChar+" characters of the given string :"+ firstFewChar);
	break;
	}
	case 8:{
	int indexNo=0;
	System.out.println("=== Replacing Strings !! ===");
	str = getValidInputString(scanner,"Enter original String : ");
	String replacement = getValidInputString(scanner,"Enter replacement String :");
	String mode = getValidInputString(scanner, "Enter the type of replacement (prefix,suffix,any) : ");
	String type= mode.toLowerCase();
	if(type.equals("any")){
		indexNo = getValidIntegerInput(scanner,"Enter the index No. for any type of replacement : ");
		}
	String modifiedString = word.toReplacePartOfString(replacement,str,mode,indexNo);
	System.out.println("ModifiedString : "+ modifiedString);
	break;
	}
	case 9:{
	System.out.println("===== Checking if the string starts with the original string =====");
	str = getValidInputString(scanner,"Enter a String : ");
	String enteredString = getValidInputString(scanner,"Enter a String to check : ");
	System.out.println("Entered string starts with the original string - "+ word.startWith(enteredString,str));
	break;
		}
	case 10:{
	System.out.println("===== Checking if the string ends with the original string =====");
	str = getValidInputString(scanner,"Enter original String : ");
	String enteredString = getValidInputString(scanner,"Enter a String to check : ");
	System.out.println("Entered string ends with the original string"+ word.endWith(enteredString,str));
	break;
	}
	case 11:{
	System.out.println("=== UPPERCASE ===");
	str = getValidInputString(scanner,"Enter a String : ");
	System.out.println("UPPERCASE : "+ word.convertToUpperCase(str));
	break;
	}
	case 12:{
	System.out.println("=== LOWERCASE ===");
	str = getValidInputString(scanner,"Enter a String : ");
	System.out.println("lowercase : "+ word.convertToLowerCase(str));
	break;
	}
	case 13:{
	System.out.println("=== Reversing a String ===");
	str = getValidInputString(scanner,"Enter a String : ");
	System.out.println("Reversed String : "+ word.toReverse(str));
	break;
	}
	case 14:{
	System.out.println("=== Removing Spaces ====");
	String spacedString = getValidInputString(scanner,"Enter a string with spaces : ");
	System.out.println("strings with spaces in a single line after removing spaces : "+ word.toRemoveSpaces(spacedString));
	break;
	}
	case 15:{
	System.out.println("=== Converting string into string array using a seperator ===");
	String multiString= getValidInputString(scanner,"Enter a String : ");
	String seperator = getValidInputString(scanner,"Enter seperator : ");
	System.out.println("spaced strings to String arr : "+ Arrays.toString(word.convertToStringArr(seperator,multiString)));
	break;
	}
	case 16:{
	System.out.println("Comparing two strings whether it is equal or not");
	String mainString = getValidInputString(scanner,"Enter String 1 : ");
	String compareString = getValidInputString(scanner,"Enter String 2 : ");
	System.out.println("String1 is equal to String2 (case sensitive) - "+ word.compareStringIncludeCase(mainString,compareString));
	System.out.println("String1 is equal to String2 (ignore case) - "+ word.compareStringExcludeCase(mainString,compareString));
	break;
	}
	case 17:{
	System.out.println("====== Removing extra spaces in the beginning and end ======");
	String stringWithSpace = getValidInputString(scanner,"Enter a string which has spaces in the beginning and ending :");
	System.out.println("String after removing extra spaces :" + word.trimSpacesAtBeginAndEnd(stringWithSpace));
	break;
	}
	case 18:{
	System.out.println("===Write multiple strings to merge them in a single line seperated by a character===");
	ArrayList<String> multipleStrings = new ArrayList<String>();
	int n=1;
	while(true){
	 	System.out.print("String "+n+ " : ");
	 	String toMerge= scanner.nextLine();
	 	n++;
	 	if (toMerge.isEmpty()){
	 		break;
	 		}
	 	multipleStrings.add(toMerge);
	 	}
	String mergingChar = getValidInputString(scanner,"Enter the character : ");
	System.out.println("Merged Strings with a character inbetween : "+ word.toMergeStrings(multipleStrings,mergingChar));
	break;
	}
	default:{
		System.out.println("==== Exit ====");
	}
	}
	}
	catch(InvalidInputException error){
		System.out.println("Error : "+ error.getMessage());
		exit = true;
		}
	
	}while(exit);
	
}
public static String getValidInputString(Scanner scanner,String prompt){
	String str;	
	System.out.print(prompt);
	str = scanner.nextLine();
	return str;
	}
public static int getValidIntegerInput(Scanner scanner, String prompt) {
    int input=0;
    boolean validInput = false;
    while (!validInput) {
        System.out.print(prompt);
        try {
            input = scanner.nextInt();
            scanner.nextLine();  
            validInput = true;          
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer."); 
            scanner.nextLine();
    }
	}
	return input;
}
}	
