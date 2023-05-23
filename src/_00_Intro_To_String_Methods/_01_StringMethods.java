package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	int q1 = s1.length();
    	int q2 = s2.length();
    	if (q1>q2) {
    		return s1;
    	}
        return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	String sub = "underscores";    
    	int num = 0;
            int index = s.indexOf(sub);
            while( index != -1 ) {
                num++;
                index = s.indexOf(sub, index + sub.length());
            }
        if(num > 0) {
    		String p = s.replace(" ", "_");
    		 return p;
    	}
        else {
        return s;	
        }
       
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
      String t1 = s1.trim();
      String t2 =  s2.trim();
      String t3 = s3.trim();
       int n1 =t1.indexOf(' ');
       int n2 =t2.indexOf(' ');
       int n3 =t3.indexOf(' ');
    	char c1 = t1.charAt(n1+1);
        char c2 = t2.charAt(n2+1);
        char c3 = t3.charAt(n3+1);
        if(c1<=c2 && c1<=c3){
        	return t1;
        }
        else if(c2<=c1 && c2<=c3){
        	return t2;
        }
    	return t3;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int num = 0;
    	for (int j = 0; j < 10; j++) {
			String substring = Integer.toString(j);;
	    	int numOccurances = 0;
	        int index = s.indexOf(substring);
	        while( index != -1 ) {
	            numOccurances++;
	            index = s.indexOf(substring, index + substring.length());
	        }	
	        num+=(numOccurances*j);
		}
    	
        return num;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
           int numOccurances = 0;
           int index = s.indexOf(substring);
           while( index != -1 ) {
               numOccurances++;
               index = s.indexOf(substring, index + substring.length());
           }
        return numOccurances;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	byte[] b = s.getBytes();
    	byte b2 = (byte) key;
    	String q = Utilities.encrypt(b, b2);
		return q;

    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	byte b2 = (byte) key;
    	String q = Utilities.decrypt(s, b2);
        return q;
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
        String sub = substring + " ";    
    	int numOccurances = 0;
            int index = s.indexOf(sub);
            while( index != -1 ) {
                numOccurances++;
                index = s.indexOf(sub, index + sub.length());
            }
			return numOccurances;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	
    	int i=s.indexOf(substring);
        int i2=s.lastIndexOf(substring);
       int answer = i2-(i+substring.length());
        return answer;

    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	s.trim();
    	s.replace(" ", "");
    	s.replace(",", "");
    	s.replace(".", "");
    	s.replace("!", "");
    	s.replace("?", "");
    	s.replace("-", "");
    	s.replace(":", "");
    	s.toLowerCase();
    	String sub1 = s.substring(0, s.length()/2);
    	String sub2 = s.substring(s.length()/2, s.length());
    	if(sub1==sub2) {
        return true;
    	}
		return false;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
