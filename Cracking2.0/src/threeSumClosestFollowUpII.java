/* OMG, this program runs perfectly, I believe it can tackle all cases and return the correct result,
 * but the problem is that it's not efficient enought so that it gets rejected on Leetcode b/c it
 * exceeds runtime limit!
 * 
 * I'll write a completely new program in another Java class! */

/* Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). */
public class threeSumClosestFollowUpII {
	public static int threeSumClosest(int[] num, int target) {
		int len = num.length;
		if(len == 0){
			return 0;
		}
		if(len <= 3){
			int sum = 0;
			for(int i : num){
				sum += i;
			}
			return sum;
		}


		int sum = num[0] + num[1] + num[2];
		int delta = Math.abs(target - sum);
		int minSum = sum;
		int i = 0, j = 0, k = 0;
		/* use the three pointers to indicate three numbers in this array */
		for(i = 0; i < len; i++){
			for(j = 0; j < len; j++){
				if(i != j){
					for(k = 0; k < len; k++){
						if(i != j && i != k && j != k){
							sum = num[i] + num[j] + num[k];
							if(Math.abs(sum - target) < delta){
								delta = Math.abs(sum - target);
								minSum = sum;
								System.out.println("num[" + i + "] = " + num[i] + 
										"\tnum[" + j + "] = " + num[j] + "\t" + 
										"num[" + k + "] = " + num[k] + "\tminSum = " + minSum);
							}
						}
					}
				}
			}
		}
		return minSum;
	}
	public static void main(String args[]){
		//test case 1 with target 18:
//		int [] num = new int[]{-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
		
		//test case 2 with target -76:
//		int [] num = new int[]{4,-8,98,-51,73,12,-31,39,87,-16,20,69,18,59,54,44,-58
//				,40,-36,22,-60,-8,-43,83,88,1,-25,71,-53,33,60,32,61,-5,28,38,-28,45
//				,25,-68,-60,-87,5,-94,-19,-31,-35,-29,0,24,-62,-84,-7,-94,-89,12,97
//				,-32,-89,92,-50,-54,-18,12,84,-81,-99,67,24,-4,-88,61,48,-17,-17,-44
//				,65,-18,-47,68,0,-7,78,36,0,-15,23,-4,1,-74,-64,-53,-82,-10,34,-57,
//				-93,65,-3,-73,-8,-59,96,35,51,49,92,-8,-4,-100,-64,5,-86,-26,71,60,
//				-85,-42,-13,-10,17,-11,59,-14,-5,34,-36,24,9,78,48,24,-88,-46,-76,31
//				,-47,-68,29,34,-97,-69,-41,-87,-42,96,0,-90,51,-55,57,86,-61,41,1,-90
//				,-9,63,84,-32,80,-15,-12,0,72,-22,-6,-64,94,23,-80,-25,-37,-38,69,12,
//				-64,-95,-65,5,15,-31,-68,-55,-100,-89,-24,-66,33,-14,-40,-50,-19,-79,-4};

		//test case 3 with target 100;
		int [] num = new int[]{1, 2, 3, 90, 19};
		System.out.println(threeSumClosest(num, 100));
	}
}
