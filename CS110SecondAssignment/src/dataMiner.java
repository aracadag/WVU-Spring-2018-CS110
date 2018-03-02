//Take all System.out.printlns out of the driver class
//Clean up dependencies within the driver class
/*Maybe adjust spamList so it counts something as spam even if it's different so long as it falls within an
 	acceptable error range */


/*	Textfile Analyzer
	by Alan Racadag
	CS110 Spring 2018
	
	This class creates objects intended to facilitate data analysis of text files.
	
	TEXT FILE ARRAY
	This class creates a "dataMiner" object that holds a String[] array called "textFileArray."
	"textFileArray" remains uninitialized until created by one of the provided methods. When
	populated, it contains a conversion of a provided text file from text file to array, wherein
	each index of the array holds one line of the text file, in order.
	
	
	"dataMiner" objects also contain an ArrayList of String wrapper type called "spamList". It is
	empty when initialized and populates when called by a provided method. This ArrayList will then
	contain any line of text contained in textFileArray that appears multiple times throughout
	textFileArray.
	
	This class comes with a few methods:
		
			dataMiner() is the default constructor. Upon calling, a new dataMiner object is created
			and no additional actions occur.
		
			dataRead(String) buffers through a text file provided by the user and prints out the
			size in lines of the text file.
		
			dataCreateArray(String) also buffers through a text file provided by the user and prints
			out the size in lines of the text file. Additionally, it initializes textFileArray
			(previously declared but uninitialized) by filling it line by line with the provided text
			file.
			
			createSpamList() takes the array of lines converted from a text file and creates a new ArrayList
			containing all posts that appear multiple times.
		
			dataMultipleKeywordEntryCount(String, String[]) receives an array of keywords and a String array
			converted from a text file, then reads through the array, searching each value for every keyword
			from the keyword array. Each time it finds a line that contains all keywords, it adds to a running
			tally. When finished, it returns the tally as an integer.
		
			dataKeywordEntryCount(String, String[]) receives a keyword a String array from the user and then
			reads through the array, searching each value for the keyword. Each time it finds a line with the
			keyword, it adds to a running tally. When finished, it returns the tally as an integer.
			
			dataMultipleKeywordEntryPrint(String, String[]) receives an array of keywords and a String array
			converted from a text file, then reads through the array, searching each value for every keyword
			from the keyword array. Each time it finds a line that contains all keywords, it prints that line.
		
			dataKeywordEntryPrint(String, String[]) receives a keyword a String array from the user and then
			reads through the array, searching each value for the keyword. Each time it finds a line with the
			keyword, it prints the line.

			dataKeywordSpamCount(String[]) receives a String array from the user and reads through the array,
			comparing each value in the array against every value in an ArrayList<String> called "spamList."
			When it finds two values that are identical, it breaks the inner loop and increments a tally called
			"spamCount" by 1. If it doesn't find a matching value between the given array and spamList, it then
			compares the given array against every value in that same array. When it finds two values that are
			identical, it breaks the inner loop and increments spamCount by 1. After the outer for-loop has
			iterated through the entire given array, the method returns spamCount as an integer.
			
			dataMultipleCount(String[]) receives a String array from the user. Then, if it detects that the first
			value of the ArrayList<String> called "spamList" is null, it runs through the same actions as
			dataKeywordSpamCount(String[]) but without counting or reporting a tally of non-unique values. Thus,
			it initializes spamList if it hasn't been initialized already. Following this, a new integer array
			called "spamListTallyList" is created that is the same size as spamList.
				This new array keeps track of the number of times each value in spamList appears in the String
			array provided by the user. The method will examine each value in the provided array. If it finds
			a line that is identical to a line in spamList, it will increment the value in spamListTallyList
			whose index matches the index of the matched line in spamList.
				Following this, a new integer is created called multipleCountArray with a size of 10. The method
			then examines each value in spamListTallyList. If a value in spamListTallyList matches the number of
			an index n-1 in multipleCountArray, it will increment index n in multipleCountArray by 1. The method
			then returns multipleCountArray.
			
			getTextFileArray() returns textFileArray.
			
			getSpamList() returns spamList.
*/







import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class dataMiner {

	//private String fileToAnalyze = null;
	private String[] textFileArray;
	private ArrayList<String> spamList =new ArrayList<String>();
	public String[] keywordsToSearchForArray;
	int textFileSize=0;
	
	dataMiner(){
		//System.out.println("Default constructor");
		//create the array here
		//create spamlist here
	}
	
	//-----------------------------------------------------initializes an array of keywords to search for
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void initializeKeywordsToSearchForArray(int numberOfKeywords) {
		keywordsToSearchForArray = new String[numberOfKeywords];
	}
	
	
	//-------------------------------------reads the text file and prints the number of lines in the file
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public int dataReadLength(String fileInput) {
		try {
			FileReader myFileReader = new FileReader(fileInput);
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			//System.out.println("File opened.");
			textFileSize = 0;

			while(myBufferReader.readLine() != null) {
				textFileSize++;
			}
			//System.out.println("The file is " + textFileSize + " lines long.");
			myBufferReader.close();
			
		}
		catch(Exception ex) {
			System.out.println("Exception thrown: " + ex.getMessage());
		}
		return textFileSize;
	}
	
	//-------------------converts the text file into an array (one line per index) and returns that array
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public String[] dataCreateArray(String fileInput) {
		
		try {
			FileReader myFileReader = new FileReader(fileInput);
			FileReader myFileReader2 = new FileReader(fileInput);

			BufferedReader myBufferReader1 = new BufferedReader(myFileReader);
			
		
			//System.out.println("File opened.");
		
			//Read each line
			//Determine number of lines in file
			textFileSize = 0;
			while(myBufferReader1.readLine() != null) {
				textFileSize++;
			}
			//System.out.println("The file is " + textFileSize + " lines long.");
			myBufferReader1.close(); //
		
			BufferedReader myBufferReader2 = new BufferedReader(myFileReader2);
			//Create array that is the same size as the number of lines in the file
			textFileArray = new String[textFileSize];
	
			//Store each line in the nth array slot
			//Increment the nth array slot until line==null
			int arrayCreatorCounter = 0;
		
			String temp = "";
			while((temp = myBufferReader2.readLine()) != null) {
				//temp = myBufferReader2.readLine();
				textFileArray[arrayCreatorCounter] = temp;
				//System.out.println("executed");
				arrayCreatorCounter++;
			}
		
			//int secondToLast = 0;
			//secondToLast = arrayCreatorCounter - 1;
			//System.out.println("The second to last entry in the array is " + textFileArray[secondToLast]);

			//
		
		
		/*This just prints out the text file
		String line = null;
		while(myBufferReader.readLine() != null) {
			line = myBufferReader.readLine();
			System.out.println(line);
		}*/
		
			myBufferReader2.close(); //
			myFileReader.close();
			//System.out.println("closed");
			
		}
		catch(Exception ex) {
			System.out.println("Exception thrown: " + ex.getMessage());
		}
		
		return this.textFileArray;
	}

	//--------------------------------------------counts the number of posts that mention a given keyword
	//---------------------------------------------------------second version takes two keywords as input-----------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public int dataMultipleKeywordEntryCount() {
		int entryCount = 0;
		boolean hasTheKeywords=true;
		for(String lineToAnalyze: textFileArray) {
			if(lineToAnalyze!=null) {
				for(String keyword: keywordsToSearchForArray){
					if(!lineToAnalyze.contains(keyword) && !lineToAnalyze.contains(keyword.toLowerCase()) && !lineToAnalyze.contains(keyword.toUpperCase())) {
						hasTheKeywords=false;
						break;
					}
				}
				if(hasTheKeywords) {
					entryCount++;
				}
				hasTheKeywords=true;
			}
		}
		
		return entryCount;
	}
	
	public int dataKeywordEntryCount(String keyword, String[] arrayToAnalyze) throws NullPointerException {
		int entryCount = 0;
		for(String lineToAnalyze: arrayToAnalyze) { //same thing as for (int i = 0; i < arrayToAnalyze.length; i++) but also declares container for the thing to check
			if(lineToAnalyze!=null && (lineToAnalyze.contains(keyword) || lineToAnalyze.contains(keyword.toLowerCase()))) {
				entryCount++;
			}
		}
		
		return entryCount;
	}
	
	public int dataKeywordEntryCount2(String keyword, String keyword2, String[] arrayToAnalyze) throws NullPointerException {
		int entryCount = 0;
		for(String lineToAnalyze: arrayToAnalyze) { //same thing as for (int i = 0; i < arrayToAnalyze.length; i++) but also declares container for the thing to check
			if(lineToAnalyze!=null && (lineToAnalyze.contains(keyword) || lineToAnalyze.contains(keyword.toLowerCase()))) {
				if(lineToAnalyze.contains(keyword2)||lineToAnalyze.contains(keyword2))
				entryCount++;
			}
		}
		
		return entryCount;
	}
	
	
	//------------------------------------------------------prints the posts that mention a given keyword
	//---------------------------------------------------------second version takes two keywords as input-----------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void dataMultipleKeywordEntryPrint() {
		int dataKeywordEntryPrintCounter = 1;
		boolean hasTheKeywords=true;
		for(String lineToAnalyze: textFileArray) {
			if(lineToAnalyze!=null) {
				for(String keyword: keywordsToSearchForArray){
					if(!lineToAnalyze.contains(keyword) && !lineToAnalyze.contains(keyword.toLowerCase()) && !lineToAnalyze.contains(keyword.toUpperCase())) {
						hasTheKeywords=false;
						break;
					}
				}
				if(hasTheKeywords) {
					//WARNING: Not alls platforms have a console capable of System.out.println, find a workaround. Maybe just create and return an array?
					System.out.println(dataKeywordEntryPrintCounter + ". " + lineToAnalyze);
					dataKeywordEntryPrintCounter++;
				}
				hasTheKeywords=true;
			}
		}
	}
	
	
	public void dataKeywordEntryPrint(String keyword, String[] arrayToAnalyze) throws NullPointerException {
		int dataKeywordEntryPrintCounter = 1;
		for(String lineToAnalyze: arrayToAnalyze) {
			if(lineToAnalyze!=null && (lineToAnalyze.contains(keyword) || lineToAnalyze.contains(keyword.toLowerCase()))) {
				System.out.println(dataKeywordEntryPrintCounter + ". " + lineToAnalyze);
				dataKeywordEntryPrintCounter++;
			}
		}
	}
	
	public void dataKeywordEntryPrint2(String keyword, String keyword2, String[] arrayToAnalyze) throws NullPointerException {
		int dataKeywordEntryPrintCounter = 1;
		for(String lineToAnalyze: arrayToAnalyze) {
			if(lineToAnalyze!=null && (lineToAnalyze.contains(keyword) || lineToAnalyze.contains(keyword.toLowerCase()))) {
				if(lineToAnalyze.contains(keyword2) || lineToAnalyze.contains(keyword2.toLowerCase())) {
					System.out.println(dataKeywordEntryPrintCounter + ". " + lineToAnalyze);
					dataKeywordEntryPrintCounter++;
				}
			}
		}
	}
	/*
	while((line=myBufferReader.readLine())!=null) {
		if(line.contains(keyword)){
		}
	}
	*/
	//-------------counts the number of non-unique posts and creates and ArrayList containing those posts
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Create spam list first
	//Dependent on textFileArray still existing
	public void createSpamList() throws NullPointerException {
		//int spamCount = 0;
		boolean spamFound=false;
		String textFilePost="";
		String textFilePost2="";

		//Find spam posts
		//(int i = 0; i < arrayToAnalyze.length; i++)
		//(String textFilePost: arrayToAnalyze)
		for(int i=0; i<textFileArray.length; i++) {
			textFilePost = textFileArray[i];
			if(textFilePost!=null) {
				//first check e against an ArrayList of known spam posts
				spamFound=false;
				for(String spamListPost: spamList) {
					spamFound=false;
					if(textFilePost.equalsIgnoreCase(spamListPost)) {
						spamFound=true;
						//spamCount++;
					}
					if(spamFound)
						break;
				}
				//go to the array and check against all lines in the original text
				//when a spam post is found, add it to the spamList
				if(!spamFound) {
					//(String textFilePost2: arrayToAnalyze)
					for(int j=i+1; j<textFileArray.length;j++) {
						textFilePost2=textFileArray[j];
						spamFound=false;
						if(textFilePost2.equalsIgnoreCase(textFilePost)) {
							spamList.add(textFilePost);
							spamFound=true;
							//spamCount++;
						}
						if(spamFound)
							break;
						}
					}
				}
		}	
	}
	
	
	public int dataKeywordSpamCount(String[] arrayToAnalyze) throws NullPointerException {
		int spamCount = 0;
		boolean spamFound=false;
		String textFilePost="";
		String textFilePost2="";

		//Find spam posts
		//(int i = 0; i < arrayToAnalyze.length; i++)
		//(String textFilePost: arrayToAnalyze)
		for(int i=0; i<arrayToAnalyze.length; i++) {
			textFilePost = arrayToAnalyze[i];
			if(textFilePost!=null) {
				//first check e against an ArrayList of known spam posts
				spamFound=false;
				for(String spamListPost: spamList) {
					spamFound=false;
					if(textFilePost.equalsIgnoreCase(spamListPost)) {
						spamFound=true;
						spamCount++;
					}
					if(spamFound)
						break;
				}
				//go to the array and check against all lines in the original text
				//when a spam post is found, add it to the spamList
				if(!spamFound) {
					//(String textFilePost2: arrayToAnalyze)
					for(int j=i+1; j<arrayToAnalyze.length;j++) {
						textFilePost2=arrayToAnalyze[j];
						spamFound=false;
						if(textFilePost2.equalsIgnoreCase(textFilePost)) {
							spamList.add(textFilePost);
							spamFound=true;
							spamCount++;
						}
						if(spamFound)
							break;
						}
					}
				}
		}
		
		return spamCount-spamList.size();
		//because the counting method counts the original copied line as a copy, we must subtract
		//them from the total. This is simpler and less resource-intensive than re-writing the code
		//to get the total correct the first time it counts it.
	}
	
	
	
	//----------------------------------tallies how many unique messages appear a certain number of times
	//---for instance, "2 messages appear once, 4 messages appear twice, 1 message appears three times...-----------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public int[] dataMultipleCount(String[] arrayToAnalyze) {
		int[] multipleCountArray = new int[10];
		boolean spamFound=false;
		
		//create spam list first if it doesn't already exist
		if(spamList.get(0)==null) {
			System.out.println("Spam list didn't exist. Creating it now.");
			//int spamCount = 0;

			//Find spam posts

			for(String textFilePost: arrayToAnalyze) {
				if(textFilePost!=null) {
					//first check e against an ArrayList of known spam posts
					spamFound=false;
					for(String spamListPost: spamList) {
						spamFound=false;
						if(textFilePost.equalsIgnoreCase(spamListPost)) {
							spamFound=true;
							//spamCount++;
						}
						if(spamFound)
							break;
					}
					//go to the array and check against all lines in the original text
					//when a spam post is found, add it to the spamList
					if(!spamFound) {
						for(String textFilePost2: arrayToAnalyze) {
							spamFound=false;
							if(textFilePost2.equalsIgnoreCase(textFilePost)) {
								spamList.add(textFilePost);
								spamFound=true;
								//spamCount++;
							}
							if(spamFound)
								break;
							}
						}
					}
			}
		}
		
		int[] spamListTallyList = new int[spamList.size()];

		//Read through the pre-made array made from the text file
		for(String textFilePost: arrayToAnalyze) {
			//System.out.println("Checking for: " + textFilePost);
			//first check textFilePost against an ArrayList of known spam posts
			//if found, add to that known spam post's spamListTally
			if(textFilePost!=null) {
				for(int i=0; i < spamList.size(); i++) {//for(String spamListPost: spamList) { //(int i = 0; i < arrayToAnalyze.length; i++)
					String spamListPost = spamList.get(i);
					//spamFound=false;
					//System.out.println(spamListPost);
					if(textFilePost.equalsIgnoreCase(spamListPost)) {
						//lookup index of spamListPost, then add 1 to that index but in spamListTallyList
						//System.out.println(spamListPost);
						spamListTallyList[i]++;
					}
				}
			}
		}
		
		//---------------------------------------------------Add up the number of times each multiple appears
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		for(int spamListTally: spamListTallyList) {

			if(spamListTally==2) {
				multipleCountArray[1]++;
			}else if(spamListTally==3) {
				multipleCountArray[2]++;
			}else if(spamListTally==4) {
				multipleCountArray[3]++;
			}else if(spamListTally==5) {
				multipleCountArray[4]++;
			}else if(spamListTally==6) {
				multipleCountArray[5]++;
			}else if(spamListTally==7) {
				multipleCountArray[6]++;
			}else if(spamListTally==8) {
				multipleCountArray[7]++;
			}else if(spamListTally==9) {
				multipleCountArray[8]++;
			}else if(spamListTally==10){
				multipleCountArray[9]++;
			}
			
			multipleCountArray[0] = textFileSize-multipleCountArray[1]-multipleCountArray[2]-multipleCountArray[3]
					-multipleCountArray[4]-multipleCountArray[5]-multipleCountArray[6]-multipleCountArray[7]-multipleCountArray[8]
							-multipleCountArray[9];
		}
		
		return multipleCountArray;
	}
	
	//-----------------------------gets the text file array created in the above method dataCreateArray()
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public String[] getTextFileArray() {
		return this.textFileArray;
	}
	
	//------------------------------gets the ArrayList created in the above method dataKeywordSpamCount()
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public ArrayList<String> getSpamList() {
		return this.spamList;
	}
}
