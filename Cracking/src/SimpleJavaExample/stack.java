package SimpleJavaExample;

public class stack {

	int stackSize = 100;
	int[] buffer = new int [stackSize * 3];
	int[] stackPointer = {-1, -1, -1};
	
	public void push(int stackNum, int value) throws Exception {
		/*check if we have space*/
		if(stackPointer[stackNum] + 1 >= stackSize) {
			throw new Exception ("Out of space.");
		}
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}
	
	public int pop (int stackNum) throws Exception {
		if(stackPointer[stackNum] == -1){
			throw new Exception ("Trying to pop an empty stack.");
		}
		int value = buffer[absTopOfStack(stackNum)]; //get top
		buffer[absTopOfStack(stackNum)] = 0; //clear index
		stackPointer[stackNum]--;
		return value;
	}
}
