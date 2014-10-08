package SimpleJavaExample;

/*This example shows how to sort Java Vector object using Collections.sort() method.*/

import java.util.Collections;
import java.util.Vector;


public class SortVector {

	public static void main (String[] args){
		Vector vec = new Vector();
		
		vec.add("Steve");
		vec.add("Jason");
		vec.add("Ralph");
		vec.add("Theo");
		
		System.out.println("Before sorting, the vec is " + vec + ".");
		Collections.sort(vec);
		System.out.println("After sorting, the vec is " + vec + ".");
		
	}
}
