package stringsimilarity;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Student {
	private int number;
	private String name;
	private Code code;

	private void initialize(String code) {
		this.code = new Code(code);
	}
	
	Student(int number, String name, String code){
		this.number = number;
		this.name = name;
		initialize(code);
	}
	
	Student() {
		initialize("");
	}

	public int getNumber() {
		return number;
	}
	
	public void getNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void plusCode(String nextLine) {
		
		this.code.plusCode( nextLine );
		
	}
	public void getName(String name) {
		this.name = name;
	}
		
	public String getCode() {
		return this.code.getCode();
	}
	


	public void pretreatment() {
		this.code.pretreatment();
		
	}

	public void findHashCodeOfKGrams() {
		
		this.code.findHashCodeOfKGrams();
		
	}

	public void findFingerPrint() {
		this.code.findFingerPrint();
		
		
	}


	public double findSimilarity(Student jack) {
		
		
		return this.code.findSimilarity( jack );
		
	}

	public int getFingerPrintSize() {
		return this.code.getFingerPrintSize();
	}

	public boolean hashFingerPrint(Integer fP) {
		
		return this.code.hashFingerPrint( fP );
	}

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
	}

}
