
public class MagicSquare {

	public int[][] findMagicSquare(int size)
	{
		int[][] result = null;
		if (size <=2)
		{
			result = new int[][]{};
		}
		// Odd 
		else if ((size & 1) == 1)
		{
			result = new int[size][size];
			for (int i = 1 ; i <= size; i++)
			{
				for (int j = 1; j <= size; j++)
				{
					result[i-1][j-1] = size * ((i+j-1+size/2) % size) + ((i+2*j-2) % size) + 1;
				}
			}
		}
		// 4m
		else if (size % 4 == 0)
		{
			result = new int[size][size];
			for (int row=0;row<size;row++)
			{
				for (int column=0;column< size;column++)
				{
					result[row][column]= row*size+column+1;
				}
			}
			
			/*
			 * switch square[n][p] and square[size-n][size-p]
			 */
			for (int row = 0; row < size; row ++)
			{
				for (int column = 0 ; column < size/2 ; column++)
				{
					if (!(row %4 == column %4) && !( (size-row-1)%4 == column%4)) 
					{
						int temp = result[row][column];
						result[row][column] = result[size-1-row][size-1-column];
						result[size-1-row][size-1-column] = temp;
					}
				}
			}
		}
		// 4M + 2
		else
		{
			
		}
			
		return result;
	}
}
