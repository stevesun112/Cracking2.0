package SimpleJavaExample;
import java.util.HashMap;


public class SimpleHashMapExample {

	public static void main(String args[]){
		HashMap hm = new HashMap();
		hm.put(0, new String("Steve"));
		hm.put(1, new String("文芸"));
		hm.put(2, ("Sun"));
		/*
	      Please note that put method accepts Objects. Java Primitive values CAN NOT
	      be added directly to HashMap. It must be converted to corrosponding
	      wrapper class first.
	    
	    * I copied the above comment from online, as I did for putting "Steve" and “文芸"
	    * into HashMap, but when I get rid of the wrapper class, as I did for "Sun", it
	    * actually also works.
	    * So, I'm confused...???
	    */
		Object values[] = new Object[3];
		values[0] = hm.get(0);
		values[1] = hm.get(1);
		values[2] = hm.get(2);
		for(int i = 0; i < 3; i++){
			System.out.println(values[i]);
		}
	}
}
