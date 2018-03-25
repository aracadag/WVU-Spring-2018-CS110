
public class DataAnalyzerAuthor {
	String name=null;
	int totalScore=0;
	int totalNrComments=0;
	int totalNrOfScores=0;
	int totalNrOfNrOfComments=0;
	int avgScore=0;
	int avgNrComments=0;
	
	DataAnalyzerAuthor(String newName, int newTotalScore, int newTotalNrComments, int newTotalNrOfScores, int newTotalNrOfNrOfComments, int newAvgScore, int newAvgNrComments){
		name=newName;
		totalScore=newTotalScore;
		totalNrComments=newTotalNrComments;
		totalNrOfScores=newTotalNrOfScores;
		totalNrOfNrOfComments=newTotalNrOfNrOfComments;
		avgScore=newAvgScore;
		avgNrComments=newAvgNrComments;
	}
}
