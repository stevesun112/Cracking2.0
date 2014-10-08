import java.util.ArrayList;
import java.util.HashMap;


/*Be familiar with the most frequently used methods in HashMap:
 *HashMap.get(key);		using key to get the value
 *.put(key, value); 	put the key and value pair into the HashMap
 *.contains(value); 	check if the HashMap contains this value
 *.values(); 			get all the VALUES in this HashMap
 **/

public class HashMapPractice {

	public static void main(String args[]){
		HashMap<Integer, ArrayList<String>> CSgroup = new HashMap();
		ArrayList<String> allstring = new ArrayList<String>();
		allstring.add("David Du");
		allstring.add("Chris Huang");
		allstring.add("Shelly Zou");
		CSgroup.put(0, allstring);
		
		ArrayList<String> nameArray = CSgroup.get(0);
		
		for(String name : nameArray){
			System.out.println(name);
		}
		
	}
}
