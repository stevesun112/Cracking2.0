/* Originally I was going to solve this following leetcode problem here, but my algorithm is buggy,
 * 
 * it can pass 105/119 test cases 
 * 
 * on Leetcode but failed the test case in the main program here,
 * because of the fundamental defect in my algorithm, I always bundle two elements together,
 * this is the source of the bug, the three elements can be completely allocated away from each other,
 * so I'll rewrite my program in another Java class. */


/* Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). */

public class threeSumClosestFollowUp {
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
		int minSum = sum;
		int delta = Math.abs(sum - target);
		int i, j;
		/* use these two pointers to traverse this array, the pointer i
		 * points two adjacent numbers in the array, i.e. the ith number
		 * and the (i+1)th number while the pointer j moves around to point
		 * to the third number. */
		for(i = 0; i < len - 1; i++){
			int twoSum = num[i] + num[i+1];
			for(j = 0; j < len; j++){
				if(j != i && j != (i+1)){
					sum = twoSum + num[j];
					if(Math.abs(sum - target) < delta){
						delta = Math.abs(sum - target);
						minSum = sum;
					System.out.println("num[" + i + "] = " + num[i] + "\tnum[" + (i+1) +"] = " + num[i+1]
				+ "\tnum[" + j + "]" + num[j] + "\tdelta = " + delta + "\tminSum = " + minSum);
					}
				}
			}	
		}

		return minSum;
	}
	public static void main(String args[]){
		int [] num = new int[]{-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
		System.out.println(threeSumClosest(num, 18));
	}
}
