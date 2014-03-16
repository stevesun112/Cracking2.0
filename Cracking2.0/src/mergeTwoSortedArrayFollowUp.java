/* This program works totally fine, but it cannot produce correct result on Leetcode, very frustrated,
 * I'll write a new program. */
public class mergeTwoSortedArrayFollowUp {
	public static void merge(int A[], int m, int B[], int n) {

		int [] tempA = new int[A.length];

		for(int i = 0; i < A.length; i++){
			tempA[i] = A[i];
			System.out.print(tempA[i]);
		}
		int lenA = A.length;
		int lenB = B.length;
		
		int i, j, k;
		for(i = 0, j = 0, k =0; i < m && j < n; ){
			System.out.println("A[" + i + "] = " + A[i] + "\tB[" + j + "] = " + B[j] + "\ttempA[" + k + "] = " + tempA[k] );
			if(A[i] < B[j]){
				tempA[k++] = A[i++];
			}
			else if(A[i] > B[j]){
				tempA[k++] = B[j++];
			}
			else{
				tempA[k++] = A[i++];
				tempA[k++] = B[j++];
			}
		}
		if(j == n){
			for(; i < m && k < lenA; i++, k++){
				System.out.print("A[" + i + "] = " + A[i] + "\ttempA[" + k + "] = " + tempA[k] + "\n");
				tempA[k] = A[i];
				System.out.print("tempA[" + k + "] = " + tempA[k] + "\n");
			}
		}
		else if(i == m){
			for(; j < n; j++, k++){
				tempA[k] = B[j];
			}
		}
		
		System.out.println("Here is " + tempA[0]);
		for(int p = 0; p < m + n; p++){
			System.out.print(tempA[p]);
		}
	}
	public static void main(String args[]){
		/* test case 1: */
//				int [] A = new int[7];
//				A[0] = 1;
//				A[1] = 2;
//				A[2] = 3;
//				int [] B = new int[]{4, 5, 6};


		/* test case 2: */
//				int [] A = new int[7];
//				A[0] = 7;
//				A[1] = 8;
//				A[2] = 9;
//				int [] B = new int[]{1, 2, 3};


		/* test case 3: */
//				int [] A = new int[7];
//				A[0] = 1;
//				A[1] = 2;
//				A[2] = 6;
//				A[3] = 7;
//				int [] B = new int[]{3, 4, 5};


		//test case 4:
//		int [] A = new int[7];
//		A[0] = 6;
//		A[1] = 7;
//		A[2] = 8;
//		A[3] = 9;
//		int [] B = new int[]{3, 4, 5};
		
		//test case 5:
		int [] A = new int[7];
		A[0] = 1;
		A[1] = 2;
		A[2] = 3;
		int [] B = new int[]{2, 5, 6};
		
//		int [] A = new int[7];
//		int [] B = new int[]{1};

		for(int i = 0; i < A.length; i++){
			System.out.print(A[i]);
		}
		System.out.println();
		for(int i = 0; i < B.length; i++){
			System.out.print(B[i]);
		}
		System.out.println();
		merge(A, 3, B, 3);
		System.out.print("\nProgram finished.");
	}
}
