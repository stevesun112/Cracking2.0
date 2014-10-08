package SimpleJavaExample;
import java.util.*;


public class iterativeMethod {
	ArrayList<String> familyTree = new ArrayList<String>();
	public static void main (String [] args){
		new iterativeMethod().getSon();
		}
	public void getSon(){
		getGrandSon();
	}
	void getGrandSon(){
		System.out.print("My grandson is Steve Sun.\n");
	}
}
