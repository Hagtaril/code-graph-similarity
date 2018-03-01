package stringsimilarity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileI {
	private Student newStudent = new Student();
	
	FileI(String fileName) throws IOException {

		File file = new File(fileName);
		
		Scanner input = new Scanner(file);
		
		this.newStudent.getNumber( input.nextInt() );;
		this.newStudent.getName( input.nextLine() + input.nextLine() );


		while ( input.hasNextLine() ) {
			String s = input.nextLine();
			this.newStudent.plusCode( s );
		}
			
		input.close();
		
		this.newStudent.pretreatment();
	}
	
	public Student getNewStudent () {
		return newStudent;
	}
	
	public static void main(String[] args)  {
		
	}

}
