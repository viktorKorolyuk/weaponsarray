package vafspy.weparr;

public class PhoneNumberCoder {
	
	
	public static void main(String[] args){
		String str = "180-JUSTICE";
		String reconstructed = "";
		for (String retval : str.split("")){
		     String regx = retval.replaceAll("[a-zA-Z]", "is_a_letter");
	         if(regx.equals("is_a_letter")) {
	        	 // Convert this one
	        	 System.out.println(retval);
	        	 if(retval.replaceAll("[a-cA-C]","is_2") == "is_2") {
	        		 reconstructed += "2";
	        		 System.out.println("YO");
	        	 }
	        	 if(retval.replaceAll("[d-fD-F]","is_3") == "is_3") {
	        		 reconstructed += "3";
	        	 }
	        	 if(retval.replaceAll("[g-iG-I]","is_4") == "is_4") {
	        		 reconstructed += "4";
	        	 }
	        	 if(retval.replaceAll("[j-lJ-L]","is_5") == "is_5") {
	        		 System.out.println("YO");
	        		 reconstructed += "3";
	        	 }
	        	 if(retval.replaceAll("[m-oM-O]","is_6") == "is_6") {
	        		 reconstructed += "6";
	        	 }
	        	 if(retval.replaceAll("[p-sP-S]","is_7") == "is_7") {
	        		 reconstructed += "7";
	        	 }
	        	 if(retval.replaceAll("[t-vT-V]","is_8") == "is_8") {
	        		 reconstructed += "8";
	        	 }
	        	 if(retval.replaceAll("[w-zW-Z]","is_9") == "is_9") {
	        		 reconstructed += "9";
	        	 }
	         } else {
	        	 reconstructed += retval;
	         }
	      }
		System.out.println(reconstructed);
	}
	
	
}
