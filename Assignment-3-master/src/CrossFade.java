import java.awt.Color;

public class CrossFade {
	
	CrossFade(){
		
	}

	//create a double exposure of the two images
	public Color[][] process(Color[][] img1, Color[][] img2, float weight2){
		Color[][] imgA = img1;
		Color[][] imgB = img2;
		Color[][] processedImage = new Color[imgA.length][imgA[0].length];
		float weight1 = 1.0f - weight2;
		
		for (int row = 0; row < imgA.length; row++) {
			for(int col = 0; col < imgA[row].length; col++) {
				Color pixel1 = imgA[row][col];
				Color pixel2 = imgB[row][col];
				
				float r1 = pixel1.getRed();
				float g1 = pixel1.getGreen();
				float b1 = pixel1.getBlue();
				
				float r2 = pixel2.getRed();
				float g2 = pixel2.getGreen();
				float b2 = pixel2.getBlue();
				
				float rMod = (r1*weight1+r2*weight2)/(weight1+weight2);
				float gMod = (g1*weight1+g2*weight2)/(weight1+weight2);
				float bMod = (b1*weight1+b2*weight2)/(weight1+weight2);
				
				processedImage[row][col] = new Color((int)rMod, (int)gMod, (int)bMod);
			}
		}
		
		return processedImage;
	}
}
