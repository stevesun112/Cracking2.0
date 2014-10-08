package SimpleJavaExample;
import java.util.Scanner;

public class refreshZoo {

	public static void main(String [] args){
		dog myDog = new dog();
		cat myCat = new cat();
		System.out.println("Please choose your pet: 1-> dog; 2->cat.");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		switch(input){
		case 1:
			myDog.speak();break;
		case 2:
			myCat.speak();break;
			default:
				System.out.println("Please choose either 1 or 2 for your pet!");
		}
	}
}


