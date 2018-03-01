package stringsimilarity;

import java.io.IOException;
import java.util.ArrayList;

public class Compare {
	private double similarity;
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) throws IOException {
		FileI newInputFile_1 = new FileI("in4.txt");
		
		Student tom = newInputFile_1.getNewStudent();
	
		
		tom.findHashCodeOfKGrams();
		
		tom.findFingerPrint(); 
		
	
		
		FileI newInputFile_2 = new FileI("in5.txt");
		
		Student jack = newInputFile_2.getNewStudent();
		
		jack.findHashCodeOfKGrams();
		
		jack.findFingerPrint();
		
		double similarity = tom.findSimilarity( jack );
		
		
		System.out.printf("The percentage of similarity is:\n %f%s\n ", similarity*100,"%");
	}

}
