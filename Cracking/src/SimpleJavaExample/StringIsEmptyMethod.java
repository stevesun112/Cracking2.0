package SimpleJavaExample;

public class StringIsEmptyMethod {

	public static void main (String[] args){
	String[] str = new String[]{"I", "love", "QWY!", "", "Good!"};
	
	for(int i = 0; i < str.length; i++){
		if(str[i].isEmpty()){
			System.out.println("str[" + i + "]" + " is empty!");
		}
		else
			System.out.println("str[" + i + "]" + " is not empty.");
	}
	}
	
}
