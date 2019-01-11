import java.util.Arrays;

/**1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0. 
* Approach:
* Use first row has replacement array to keep track of zeroes
* Nullify those rows and columns 
* Time Complexity O(nm); Space Complexity O(1)
*/

public class ZeroMatrix_UsingReplacement {
	
	public int[][] zeroMatrix_UsingReplacement(int[][] matrix)
	{
		boolean rowhaszero = false;
		boolean columnhaszero = false; //use two boolean arrays
		
		for(int j=0; j<matrix[0].length; j++)
		{
			if(matrix[0][j] == 0) rowhaszero = true; // update boolean if row 0 has 0
		}
		
		for(int i=0; i<matrix.length; i++)
		{
			if(matrix[i][0] == 0) columnhaszero = true; // update boolean if column 0 has 0
		}
		
		for(int i=1; i<matrix.length; i++)
		{
			for(int j=1; j<matrix[0].length; j++)
			{
				if(matrix[i][j] == 0)
				{
					matrix[i][0] = 0; // for any value 0 in matrix starting from row1 column1, use 1st row and column as replacement
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=1; i<matrix.length; i++)
		{
			if(matrix[i][0] == 0) rowzero(matrix, i); //for any 0 in row1 to n, nullify that row 
				
		}
		
		for(int j=1; j<matrix[0].length; j++)
		{
			if(matrix[0][j] == 0) columnzero(matrix, j); // for any 0 in column1 to matrix[0].length nullify that column
		}
		
		if(rowhaszero) rowzero(matrix, 0); // nullify row 0 if boolean true
		if(columnhaszero) columnzero(matrix, 0); // nullify column 0 if boolean true
		
		for(int[] row: matrix) System.out.println(Arrays.toString(row));
		return matrix;
	}
	
	public void rowzero(int[][] matrix, int row)
	{
		for(int j=0; j<matrix[0].length; j++) // nullify a complete row based on row value provided
		{
			matrix[row][j] = 0;
		}
	}
	
	public void columnzero(int[][] matrix, int column)
	{
		for(int i=0; i<matrix.length; i++) // nullify a complete column based on column value provided
		{
			matrix[i][column] = 0;
		}
	}

	public static void main(String[] args) {
		ZeroMatrix_UsingReplacement ze = new ZeroMatrix_UsingReplacement();
		int[][] matrix = {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}};
		ze.zeroMatrix_UsingReplacement(matrix);
	}
}