package SimpleJavaExample;
import java.util.Arrays;


public class SortStrings {

	public static void main(String[] args){
		String[] str = new String[]{"Timothy", "John", "Mark", "Andrew", "JohnV", "Chris"};
		System.out.print("The original string array is ");
		for(int i = 0; i < str.length; i++){
			System.out.print(str[i] + " ");
		}
		System.out.println(".");
		Arrays.sort(str);
		System.out.print("The sorting string array is ");
		for(int i = 0; i < str.length; i++){
			System.out.print(str[i] + " ");
		}
		System.out.print(".");
	}
}
