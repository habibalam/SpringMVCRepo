package com.app.utility;

//This class contains utility methods related to String Operations.
public class StringUtility {

	 public static String toCommaSeparatedString(Object[] items){
	        StringBuilder sb = new StringBuilder();
	        for (Object item : items) {
	            sb.append(item).append(",");
	        }
	        if(sb.length()>0){
	            sb.deleteCharAt(sb.length()-1);
	        }
	        return sb.toString();
	    }
}
