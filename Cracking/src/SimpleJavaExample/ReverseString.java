package SimpleJavaExample;
/*The easiest way to reverse a string in java is to use the reverse() method in the StringBuffer class*/
public class ReverseString {
public static void main (String[] args){
	String str = new String("Hello World from Java!");
	System.out.println("The original string is " + str + ".");
	
	str = new StringBuffer(str).reverse().toString();
	System.out.println("The reversed string is " + str + ".");
}
}
