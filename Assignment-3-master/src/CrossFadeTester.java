import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CrossFadeTester {
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		CrossFade crossFader = new CrossFade();
		
		ImageUtils utils = new ImageUtils();
		Color[][] imageOne = utils.loadImage("/Users/AlanSamuelRacadag/Downloads/Assignment-3-master/src/LennaCV.png");
		utils.addImage(imageOne, "Image 1");
		Color[][] imageTwo = utils.loadImage("/Users/AlanSamuelRacadag/Downloads/Assignment-3-master/src/LennaNewEdited.png");
		utils.addImage(imageTwo, "Image 2");
		
		
		System.out.println("Please enter a number from 0-10 indicating how present you want image two to be in the double exposure: ");
		float imageTwoPresence = (userInput.nextInt() * 0.1f);
		userInput.close();
		
		try {
			Color[][] processedImage = crossFader.process(imageOne, imageTwo, imageTwoPresence);
			utils.addImage(processedImage, "Double exposure");
			utils.display();	
			
			System.out.println("Please check the display. Your new double exposure is ready!");
			System.out.println("Thank you for using my program.");	
		} catch(InputMismatchException ime) {
			System.out.println("Input must be a number. Program will now terminate.");
		} catch(IllegalArgumentException iae) {
			System.out.println("Input must be a number from 0 to 10. Program will now terminate.");
		}	
	}
}
