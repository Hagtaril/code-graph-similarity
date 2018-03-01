package stringsimilarity;

import java.util.ArrayList;

public class Code {
	
	private final int K = 7;
	private final int W = 2;
	
	private String iniCode = "";
	private String code;
	private ArrayList<String> kGrams = new ArrayList<String>();
	private ArrayList<Integer> hashCode = new ArrayList<Integer>();
	private ArrayList<Integer> fingerPrint = new ArrayList<Integer>();
	

	
	private void symbolsReplace(String symbols) { 
		for ( int i=0; i<symbols.length(); i++) {
			String single = symbols.substring(i,i+1);
			this.code = this.code.replace(single, "");
		}

		this.code = this.code.replaceAll("(\r\n|\r|\n|\n\r|\t)", ""); 
		
		
	}
	private String deleteChinese(String str){  
		String string="";  
		for (int i = 0; i < str.length(); i++){  
		    String str0="";  
		if (str.substring(i, i + 1).matches("[\u4e00-\u9fa5]+")){  
		    
		}else{  
		    str0 = str.substring(i, i + 1) + "";  
		     }  
		    string +=str0;  
		   }  
		return string;  
	}  
	
	Code(String code) {
		this.iniCode = code;
		this.code = code;

	}
	
	public void pretreatment() {
		this.code = this.iniCode;
		String symbols = " ,;<>()/*:\n{}#";
		
		symbolsReplace(symbols);
		this.code = deleteChinese(this.code);
		this.code = this.code.toLowerCase();
		
		makeKGrams();
	}
	
	private void makeKGrams() {
		for ( int i=0; i<this.code.length()-K; i++ ) {
			kGrams.add( this.code.substring(i, i+K) );
		//	System.out.println( kGrams.get(i) );
		}
	}

	public String getCode() {
	//	System.out.println( this.code );
		return this.code;
	}
	
	public void plusCode(String nextLine) {
	
		this.iniCode = this.iniCode + nextLine;
		
	}
	
	public void findHashCodeOfKGrams() {
		
		for ( String single : kGrams) {
			hashCode.add( single.hashCode()  );
		}
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void findFingerPrint() {
		
		for ( int i = 0; i<=hashCode.size() - W ; i++) {
			int res = 0;
			for ( int j = 0; j<= W-1; j++) {
				res = Math.min(res, hashCode.get( i+j ));
			}
			if ( fingerPrint.contains( res )) {
				
			}else {
				fingerPrint.add(res );
			}
		}
		
	}
	public double findSimilarity(Student jack) {
		double res = 0.0;
		int simCount = 0;
		int size = Math.max( this.fingerPrint.size(), jack.getFingerPrintSize() );
		for ( Integer fP : fingerPrint ) {
			if ( jack.hashFingerPrint( fP ) ) {
				simCount++;
			}
		}
		
		res = (double)simCount / size;
		
		return res;
	}
	public int getFingerPrintSize() {
		
		return this.fingerPrint.size();
	}
	public boolean hashFingerPrint(Integer fP) {
		for ( Integer i : this.fingerPrint ) {
			if ( i.equals( fP ) ) return true;
		}
		return false;
	}



}
