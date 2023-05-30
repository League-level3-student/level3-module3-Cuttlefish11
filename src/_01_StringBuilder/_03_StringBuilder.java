package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	StringBuilder sb =  new StringBuilder(str);
    	String s = sb.append(characters).toString();
        return s;
    }
    
    public static String reverse(String str) {
    	StringBuilder builder = new StringBuilder(str);
    	String s = builder.reverse().toString();
        return s;
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder builder = new StringBuilder(str);
    	String s =builder.insert(index, newChar).toString();
        return s;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
        return null;
    }
}