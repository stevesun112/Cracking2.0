import java.util.ArrayList;

/* Cracking 1.7: 
 * Write an algorithm such that if an element in an M*N matrix is 0,
 * its entire row and column are set to 0. */

/* I figured this problem out all by myself one week ago at Mian's, hooray! 
 * After accidentally deleted it, I rewrote it again, and it worked all right!*/

public class setMatrix {

	public static void setmatrix(int[][] matrix){
		int row = matrix.length;
		System.out.println(row);
		int col = matrix[row - 1].length;
		System.out.println(col);
		ArrayList<Integer> rowContainer = new ArrayList();
		ArrayList<Integer> colContainer = new ArrayList();
		System.out.println("The input matrix is: ");
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(matrix[i][j] + "\t");		
				if(j == col - 1)
					System.out.println();
			}
		}
				
		for( int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j] == 0){
					rowContainer.add(i);
					colContainer.add(j);
				}
			}
		}
		for(int i : rowContainer){
			for( int j = 0; j < col; j++){
				matrix[i][j]= 0;
			}
		}

		for(int i : colContainer){
			for( int j = 0; j < row; j++){
				matrix[j][i] = 0;
			}
		}
		
		System.out.println("\nAfter calling setmatrix function, the output matrix is: ");
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(matrix[i][j] + "\t");		
				if(j == col -1)
					System.out.println();
			}
		}


	}

	public static void main(String args[]){
		int [][] matrix = {
				{ 1,  2,  3,  4,  5},
				{ 6,  7,  8,  9, 10},
				{11, 12, 13, 14, 15},
				{ 0, 16, 17, 18, 19}
		};
		setmatrix(matrix);
	}
}
