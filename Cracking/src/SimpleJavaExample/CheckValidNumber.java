package SimpleJavaExample;

public class CheckValidNumber {
//the following commentted out lines were written by myself, but they didn't work, so I copied the solution form online
	/*static String str1 = new String("Hello112Word!");
	
	public static void check(String str){
		
	boolean nonvalidNum = true;
	int i = 0;		
	while(nonvalidNum && i < str.length()){
	if(str[i] == {0; 1})
		nonvalidNum = false;
	else
		i++;					
		}
	if(nonvalidNum == false)
		System.out.println("This string contains valid numbers.");
	else
		System.out.println("This string doesn't contain valid numbers.");
	}
	*/
	public static void main(String[] args){
		String[] str = new String[]{"123.456", "123456", "123invalid", "123.invalid", "123456789", "987.123"};
		for(int i =0; i < str.length; i++){
			if(str[i].indexOf(".") > 0){
				try{
					Double.parseDouble(str[i]);
					System.out.println(str[i] + " is a valid decimal number.");
				}
				catch(NumberFormatException ex)
				{
					ex.printStackTrace();
					System.out.println(str[i] + " is not a valid decimal number.");
				}
				}
			else
				try{
					Integer.parseInt(str[i]);
					System.out.println(str[i] + " is a valid integer number.");
				}
			catch(NumberFormatException ex){
				ex.printStackTrace();
				System.out.println(str[i] + " is a NOT valid decimal number.");
			}
		}
		
	}
	
	
}
