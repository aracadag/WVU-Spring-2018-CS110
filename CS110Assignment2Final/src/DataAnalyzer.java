// Alan Racadag
// CS110 Assignment 2
// driver class

//	* Ranks authors according to the highest average score
//	* Ranks authors according to highest average number of responses
//	* Ranks authors according to total score
//  * Ranks authors according to total number of responses

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class DataAnalyzer {
	private String[] redditAuthors;
	private String[] redditTopicTitles;
	private int[] redditNrComments;
	private int[] redditScores;
	private String[] tempTextFileArray;
	private int[] tempTextFileArrayInt;
	private ArrayList<String> uniqueAuthorList =new ArrayList<String>();
	private ArrayList<Integer> uniqueAuthorScores = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueAuthorNrComments = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueAuthorTotalNrScores = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueAuthorTotalNrOfNrComments = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueAuthorScoreAverage = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueAuthorNrCommentsAverage = new ArrayList<Integer>();
	public String[][] top50Array = {
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
			{"null", "null", "0", "0"},
	};
	public String[][] top50AverageArray = { //author name, score average, number of comments average
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
			{"null", "0", "0"},
	};
	
	//default constructor
	DataAnalyzer(){
		redditAuthors = textFileToStringArray("redditAuthors.txt");
		redditNrComments = textFileToIntArray("redditNumberComments.txt");
		redditScores = textFileToIntArray("redditScores.txt");
		redditTopicTitles = textFileToStringArray("redditTopicTitles.txt");
	}
	
	//-------------------converts the text file into a String array (one line per index) and returns that array
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public String[] textFileToStringArray(String fileInput) {
		try {
			FileReader myFileReader = new FileReader(fileInput);
			FileReader myFileReader2 = new FileReader(fileInput);
			BufferedReader myBufferReader1 = new BufferedReader(myFileReader);
			
			//Determine number of lines in file
			int textFileSize = 0;
			while(myBufferReader1.readLine() != null) {
				textFileSize++;
			}
			myBufferReader1.close(); //
		
			BufferedReader myBufferReader2 = new BufferedReader(myFileReader2);

			//Create array that is the same size as the number of lines in the file
			tempTextFileArray = new String[textFileSize];
	
			//Store each line in the nth array slot
			//Increment the nth array slot until line==null
			int arrayCreatorCounter = 0;
		
			String temp = "";
			while((temp = myBufferReader2.readLine()) != null) {
				tempTextFileArray[arrayCreatorCounter] = temp;
				arrayCreatorCounter++;
			}
		
			myBufferReader2.close(); 
			myFileReader.close();
		}
		catch(Exception ex){
			
		}
		return tempTextFileArray;	
	}
	
	//-------------------converts the text file into an Int array (one line per index) and returns that array
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		public int[] textFileToIntArray(String fileInput) {
			try {
				FileReader myFileReader = new FileReader(fileInput);
				FileReader myFileReader2 = new FileReader(fileInput);
				BufferedReader myBufferReader1 = new BufferedReader(myFileReader);
				
				//Determine number of lines in file
				int textFileSize = 0;
				while(myBufferReader1.readLine() != null) {
					textFileSize++;
				}
				myBufferReader1.close(); //
			
				BufferedReader myBufferReader2 = new BufferedReader(myFileReader2);

				//Create array that is the same size as the number of lines in the file
				tempTextFileArrayInt = new int[textFileSize];
		
				//Store each line in the nth array slot
				//Increment the nth array slot until line==null
				int arrayCreatorCounter = 0;
			
				String temp = "";
				while((temp = myBufferReader2.readLine()) != null) {
					int i = Integer.parseInt(temp);
					tempTextFileArrayInt[arrayCreatorCounter] = i;
					arrayCreatorCounter++;
				}
			
				myBufferReader2.close(); 
				myFileReader.close();
			}
			catch(Exception ex){
				
			}
			return tempTextFileArrayInt;	
		}
	
	//-------------------Gives the Top 50 authors or topic titles according to either number of comments or score
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public String[][] top50(String whichTopTen, String whichTally) {
		String temp = whichTopTen;
		String temp2 = whichTally;
		if(whichTopTen.equalsIgnoreCase("authors")) {
			//for each index in redditAuthors, find the corresponding index in either number of comments or score,
			//then evaluate that number to see if it's greater than any number in the currently existing top 10 array.
			//If it is, then replace the number in the top 10 array with the greater number, then replace the author/title
			//at the same index with the greater number's corresponding author/title.
			if(whichTally.equalsIgnoreCase("number of comments")) {
				for(int j=0; j<redditAuthors.length; j++) {
					if(redditAuthors[j]!=null){
						for(int x=0; x<50; x++) {
							int top50ArrayToInt = Integer.parseInt(top50Array[x][2]);
							if(top50ArrayToInt < redditNrComments[j]) {
								top50Array[x][0]=redditAuthors[j];
								top50Array[x][1]=redditTopicTitles[j];
								top50Array[x][2]=Integer.toString(redditNrComments[j]);
								top50Array[x][3]=Integer.toString(redditScores[j]);
								break;
							}
						}
					}
				}
			} else if(whichTally.equalsIgnoreCase("scores")) {
				for(int j=0; j<redditAuthors.length; j++) {
					if(redditAuthors[j]!=null){
						for(int x=0; x<50; x++) {
							int top50ArrayToInt = Integer.parseInt(top50Array[x][3]);
							if(top50ArrayToInt < redditScores[j]) {
								top50Array[x][0]=redditAuthors[j];
								top50Array[x][1]=redditTopicTitles[j];
								top50Array[x][2]=Integer.toString(redditNrComments[j]);
								top50Array[x][3]=Integer.toString(redditScores[j]);
								break;
							}
						}
					}
				}
			}
			
		} else if (whichTopTen.equalsIgnoreCase("titles")) {
			if(whichTally.equalsIgnoreCase("number of comments")) {
				for(int j=0; j<redditTopicTitles.length; j++) {
					if(redditTopicTitles[j]!=null){
						for(int x=0; x<50; x++) {
							int top50ArrayToInt = Integer.parseInt(top50Array[x][2]);
							int redditNrCommentsToInt = redditNrComments[j];
							if(top50ArrayToInt < redditNrCommentsToInt) {
								top50Array[x][0]=redditAuthors[j];
								top50Array[x][1]=redditTopicTitles[j];
								top50Array[x][2]=Integer.toString(redditNrComments[j]);
								top50Array[x][3]=Integer.toString(redditScores[j]);
								break;
							}
						}
					}
				}
			} else if(whichTally.equalsIgnoreCase("scores")) {
				for(int j=0; j<redditTopicTitles.length; j++) {
					if(redditTopicTitles[j]!=null){
						for(int x=0; x<50; x++) {
							int top50ArrayToInt = Integer.parseInt(top50Array[x][3]);
							int redditScoresToInt = redditScores[j];
							if(top50ArrayToInt < redditScoresToInt) {
								top50Array[x][0]=redditAuthors[j];
								top50Array[x][1]=redditTopicTitles[j];
								top50Array[x][2]=Integer.toString(redditNrComments[j]);
								top50Array[x][3]=Integer.toString(redditScores[j]);
								break;
							}
						}
					}
				}
			}
		}		
		return top50Array;
	}
	
	//-------------------Ranks authors according to highest average score
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void top50Average(String whatKindOfAverage) {
		//create an ArrayList for every author containing each author's created topics
		//	* 	Go through the list of authors. For each one, check in an ArrayList of known authors. If
		//		the author already exists in the ArrayList of known authors, then take that author's values
		//		and put them in that author's ArrayList. If not, create a new ArrayList for that author.
		//take the numerical average of either scores or number of comments for each author's ArrayList
		//store the numerical average and author's name in the top50AverageArray IF it is greater than
		//at least one of the current values in top50AverageArray. Then, re-arrange top50AverageArray as
		//a ranking from greatest to least.
		
		//clear the top50 array first
		clearTop50AverageArray();
		
		for(int j=0; j<redditAuthors.length; j++) {
			if(!uniqueAuthorList.contains(redditAuthors[j])) {
				uniqueAuthorList.add(redditAuthors[j]);
				uniqueAuthorScores.add(redditScores[j]);
				uniqueAuthorNrComments.add(redditNrComments[j]);
				uniqueAuthorTotalNrScores.add(1);
				uniqueAuthorTotalNrOfNrComments.add(1);
				uniqueAuthorScoreAverage.add(redditScores[j]);
				uniqueAuthorNrCommentsAverage.add(redditNrComments[j]);
			} else {
				int index = uniqueAuthorList.indexOf(redditAuthors[j]);
				uniqueAuthorScores.set(index, redditScores[j]);
				uniqueAuthorNrComments.set(index, uniqueAuthorNrComments.get(index)+redditNrComments[j]);
				uniqueAuthorTotalNrScores.set(index, uniqueAuthorTotalNrScores.get(index)+1);
				uniqueAuthorTotalNrOfNrComments.set(index, uniqueAuthorTotalNrOfNrComments.get(index)+1);
			}
		}
		
		for(int j=0; j<uniqueAuthorList.size(); j++) {
			int scoreAverage = 0;
			int nrCommentsAverage = 0;
			
			scoreAverage = uniqueAuthorScores.get(j) / uniqueAuthorTotalNrScores.get(j);
			nrCommentsAverage = uniqueAuthorNrComments.get(j) / uniqueAuthorTotalNrOfNrComments.get(j);
			
			uniqueAuthorScoreAverage.set(j, scoreAverage);
			uniqueAuthorNrCommentsAverage.set(j, nrCommentsAverage);
		}
		
		for(int j=0; j<uniqueAuthorList.size(); j++) {
			for(int k=0; k<top50AverageArray.length; k++) {
				if(whatKindOfAverage.equalsIgnoreCase("scores")) {
					if(uniqueAuthorScoreAverage.get(j) > Integer.parseInt(top50AverageArray[k][1])){
						top50AverageArray[k][0] = uniqueAuthorList.get(j);
						top50AverageArray[k][1] = Integer.toString(uniqueAuthorScoreAverage.get(j));
						top50AverageArray[k][2] = Integer.toString(uniqueAuthorNrCommentsAverage.get(j));
						break;
					}
				} else if(whatKindOfAverage.equalsIgnoreCase("number of comments")) {
					if(uniqueAuthorNrCommentsAverage.get(j) > Integer.parseInt(top50AverageArray[k][2])){
						top50AverageArray[k][0] = uniqueAuthorList.get(j);
						top50AverageArray[k][1] = Integer.toString(uniqueAuthorScoreAverage.get(j));
						top50AverageArray[k][2] = Integer.toString(uniqueAuthorNrCommentsAverage.get(j));
						break;
					}
				}
			}
		}	
	}
	
	public String[][] returnTop50AverageArray(){
		return top50AverageArray;
	}
	
	public void clearTop50AverageArray() {
		for(int i=0; i<top50AverageArray.length; i++) {
			top50AverageArray[i][0] = "null";
			top50AverageArray[i][1] = "0";
			top50AverageArray[i][2] = "0";
		}
	};
}
