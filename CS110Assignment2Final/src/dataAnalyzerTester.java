//Alan Racadag
//CS110 Assignment 2
//Tester class

import java.util.Scanner;
public class dataAnalyzerTester { 
	
	static Scanner userInput = new Scanner(System.in);
	static DataAnalyzer theDataAnalyzer = new DataAnalyzer();
	static String userResponse1 = null, userResponse2 = null;
	
	public static void buildTop50() {
		System.out.println("We are going to build a Top 50 List of authors based on either number of comments or topic scores.");
		System.out.println("Would you like to populate the list based on 'number of comments' or 'scores'?: ");
		userResponse1 = userInput.nextLine();
		if(userResponse1.equalsIgnoreCase("scores"))
			theDataAnalyzer.top50Average("scores");
		else if (userResponse1.equalsIgnoreCase("number of comments"))
			theDataAnalyzer.top50Average("number of comments");
		else {
			System.out.println("Incorrect input.");
			buildTop50();
		}
		
		for(int x=0; x<50; x++) {
			System.out.println("" + theDataAnalyzer.top50AverageArray[x][0] + "    ||    " 
					+ theDataAnalyzer.top50AverageArray[x][1] + "    ||    " + theDataAnalyzer.top50AverageArray[x][2]);
		}
		
		System.out.println("Run again? (if 'y', the program will run again, otherwise the program will terminate): ");
		userResponse1 = userInput.nextLine();
		if(userResponse1.equalsIgnoreCase("y"))
			buildTop50();
		else
			System.exit(0);
	}
	
	public static void main(String[] args) {

		
		System.out.println("Welcome to CS110 Project 2 Data Analyzer: Averages Only by Alan Racadag.");

		buildTop50();
		

		
		/*System.out.println("Do you want to see Top 50 Authors or Top 50 Titles according to a yet to be named criterion? [type 'authors' or 'titles']: ");
		userResponse1 = userInput.nextLine();
		System.out.println("For what criterion do you wish to perform evaluation? [type 'number of comments' or 'scores']:");
		userResponse2 = userInput.nextLine();
		if(userResponse1.equalsIgnoreCase("authors")) {
			if(userResponse2.equalsIgnoreCase("number of comments")) {
				theDataAnalyzer.top50("authors", "number of comments");
			} else if(userResponse2.equalsIgnoreCase("scores")) {
				theDataAnalyzer.top50("authors", "scores");
			} else {
				System.out.println("You gave an input that can not be understood so the program will now terminate.");
				System.exit(0);
			}
		}else if (userResponse1.equalsIgnoreCase("titles")) {
			if(userResponse2.equalsIgnoreCase("number of comments")) {
				theDataAnalyzer.top50("titles", "number of comments");
			} else if(userResponse2.equalsIgnoreCase("scores")) {
				theDataAnalyzer.top50("titles", "scores");
			} else {
				System.out.println("You gave an input that can not be understood so the program will now terminate.");
				System.exit(0);
			}
		}else {
			System.out.println("You gave an input that can not be understood so the program will now terminate.");
			System.exit(0);
		}
		
		System.out.println("");
		for(int x=0; x<50; x++) {
			System.out.println("" + theDataAnalyzer.top50Array[x][0] + "    ||    " + theDataAnalyzer.top50Array[x][1] + "    ||    " + theDataAnalyzer.top50Array[x][2]
					 + "    ||    " + theDataAnalyzer.top50Array[x][3]);
		}*/
	}
}
