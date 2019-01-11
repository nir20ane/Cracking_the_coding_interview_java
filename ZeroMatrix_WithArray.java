/**1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0. 
* Approach:
* Have two boolean arrays to keep track of row and column that has zero
* Nullify those rows and columns 
* Time Complexity O(nm); Space Complexity O(n)
*/
import java.util.Arrays;
public class ZeroMatrix_WithArray{
	public int[][] zeroMatrix(int[][] matrix)
	{
		boolean[] row = new boolean[matrix.length]; //have two boolean arrays
		boolean[] col = new boolean[matrix[0].length];
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j] == 0)
				{
					row[i] = true;
				    col[j] = true; // keep track of rows and columns that has 0
				}
			}
		}
		for(int i=0;i<row.length;i++)
		{
			if(row[i]) rowzero(matrix, i); //nullify the rows that have 0
		}
		for(int j=0;j<col.length;j++)
		{
			if(col[j]) columnzero(matrix, j); //nullify the columns that have 0
		}
		for(int[] m: matrix) System.out.println(Arrays.toString(m));
		return matrix;
	}
	
	public void rowzero(int[][] matrix, int row)
	{
		for(int j=0;j<matrix[0].length;j++) 
		{
			matrix[row][j] = 0; // make the row 0
		}
	}
	
	public void columnzero(int[][] matrix, int column)
	{
		for(int i=0;i<matrix.length;i++)
		{
			matrix[i][column] = 0; // make the column 0
		}
	}
	
	public static void main(String[] Args)
	{
		ZeroMatrix_WithArray ze = new ZeroMatrix_WithArray();
		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		ze.zeroMatrix(matrix);
		
	}
}