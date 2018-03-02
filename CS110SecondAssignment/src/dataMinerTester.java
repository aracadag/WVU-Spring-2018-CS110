//import java.util.ArrayList;
import java.util.Scanner;


public class dataMinerTester {
	
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String textFileAddress = null;
		String keywordInput = null;
		String keywordInput2 = null;
		String yesNoInput = null;
		
		int numberOfKeywords=0;
		
		System.out.println("Welcome to Textfile Analyzer by Alan Racadag.");
		System.out.println("Please enter the file address of the textfile you intend to analyze: ");
		textFileAddress = userInput.next();
		System.out.println("");
		dataMiner dataMiner1 = new dataMiner();
		
		//read the text file
		// /Users/AlanSamuelRacadag/eclipse-workspace/CS110SecondAssignment/src/redditRawData
		// /Users/AlanSamuelRacadag/eclipse-workspace/CS110SecondAssignment/src/Untitled.txt
		
		//put text file into array
		String[] text1Array = dataMiner1.dataCreateArray(textFileAddress);
		dataMiner1.createSpamList();
		
		/*
		//-----------------------------------------------------------------number of posts containing keyword
		//---------------------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------------
		System.out.println("For what keyword do you need to know the number of lines that mentions it?: ");
		keywordInput = userInput.next();
		int wordCount = dataMiner1.dataKeywordEntryCount(keywordInput, text1Array);
		System.out.println("The number of posts mentioning " + keywordInput + " is " + wordCount + ".");
		System.out.println("");
		//-----------------------------------------------------------------------the posts containing keyword
		//---------------------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------------
		if(wordCount>0) {
			System.out.println("Would you like to read those posts?:");
			yesNoInput = userInput.next();
			if(yesNoInput.equalsIgnoreCase("y")||yesNoInput.equalsIgnoreCase("yes")) {
				//print the lines
				dataMiner1.dataKeywordEntryPrint(keywordInput, text1Array);
			}
			System.out.println("");
			int spamCount = dataMiner1.dataKeywordSpamCount(text1Array);
			System.out.println("The number of spam posts is " + spamCount + ".");
			System.out.println("");
			//ArrayList<String> spamListPrint = dataMiner1.getSpamList();
			//System.out.println(spamListPrint);
		}*/
		
		//------------------------------------------------------------number of posts containing two keywords
		//---------------------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------------
		/*System.out.println("For what 2 keywords do you need to know the number of lines that mentions it?: ");
		keywordInput = userInput.next();
		keywordInput2 = userInput.next();
		int wordCount2 = dataMiner1.dataKeywordEntryCount2(keywordInput, keywordInput2, text1Array);
		System.out.println("The number of posts mentioning " + keywordInput + " and " + keywordInput2 + " is " + wordCount2 + ".");
		System.out.println("");
		//------------------------------------------------------------------the posts containing two keywords
		//---------------------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------------
		if(wordCount2>0) {
			System.out.println("Would you like to read those posts?:");
			yesNoInput = userInput.next();
			if(yesNoInput.equalsIgnoreCase("y")||yesNoInput.equalsIgnoreCase("yes")) {
			//print the lines
				dataMiner1.dataKeywordEntryPrint2(keywordInput, keywordInput2, text1Array);
			}
			System.out.println("");
			int spamCount = dataMiner1.dataKeywordSpamCount(text1Array);
			System.out.println("The number of spam posts is " + spamCount + ".");
			//ArrayList<String> spamListPrint = dataMiner1.getSpamList();
			//System.out.println(spamListPrint);
		}*/
		
		//--------------------------------------------------------------number of posts containing n keywords
		//---------------------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------------
		System.out.println("");
		System.out.println("How many keywords do you want to search each line for?: ");
		numberOfKeywords = userInput.nextInt();
		dataMiner1.initializeKeywordsToSearchForArray(numberOfKeywords);
		for(int i=0; i<numberOfKeywords; i++) {
			System.out.println("Enter Keyword " + (i+1) + ": ");
			dataMiner1.keywordsToSearchForArray[i] = userInput.next();
		}
		System.out.println("The number of times your keywords show up in a line is: " + dataMiner1.dataMultipleKeywordEntryCount());
		System.out.println("");
		System.out.println("Would you like to read those posts?: ");
		yesNoInput = userInput.next();
		if(yesNoInput.equalsIgnoreCase("y")||yesNoInput.equalsIgnoreCase("yes")) {
			dataMiner1.dataMultipleKeywordEntryPrint();
		}

		
		
		//-------------------------------------------------------------------------------------multiple tally
		//---------------------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------------
		System.out.println("");
		System.out.println("Would you like to see the tally for posts that appear multiple times?");
		yesNoInput = userInput.next();
		System.out.println("");
		if(yesNoInput.equalsIgnoreCase("y")||yesNoInput.equalsIgnoreCase("yes")) {
			int[] multipleCountArray = dataMiner1.dataMultipleCount(text1Array);
			System.out.println("Tally for posts that appear a certain multiple number of times: ");
			System.out.println("Posts that appear 1x: " + multipleCountArray[0]);
			System.out.println("Posts that appear 2x: " + multipleCountArray[1]);
			System.out.println("Posts that appear 3x: " + multipleCountArray[2]);
			System.out.println("Posts that appear 4x: " + multipleCountArray[3]);
			System.out.println("Posts that appear 5x: " + multipleCountArray[4]);
			System.out.println("Posts that appear 6x: " + multipleCountArray[5]);
			System.out.println("Posts that appear 7x: " + multipleCountArray[6]);
			System.out.println("Posts that appear 8x: " + multipleCountArray[7]);
			System.out.println("Posts that appear 9x: " + multipleCountArray[8]);
			System.out.println("Posts that appear 10x: " + multipleCountArray[9]);
		}
		System.out.println("");
		System.out.println("Thank you for using Textfile Analyzer.");
		
		userInput.close();
	}
	
}
