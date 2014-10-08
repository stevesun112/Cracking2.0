package SimpleJavaExample;

public class Factorial {

	public static void main (String [] args){
			for(int i = 0; i< 11; i++){
			int result = fact(i); 
		System.out.println("The factorial of " + i + " is " + result + ".");
		System.out.print("Program ended.");
		}
	}
	
public static int fact(int num){
	int result;
	if(num <=1)
		result = 1;
	else
	result = fact(num-1)*num;
	return result;
}
}


