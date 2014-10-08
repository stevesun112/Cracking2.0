package SimpleJavaExample;

public class StringContainsMethod {

	public static void main (String[] args){
		String s1 = "Hello my dear Schatz!";
		String s2 = "Schatz!";
		
		boolean b = s1.contains(s2);
		System.out.println(b);
	}
}
