import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMagicSquare {

	private int size;

	public TestMagicSquare(int size) {
		this.size = size;
	}

	@Parameters
	public static Collection<Object[]> init() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 3; i < Short.MAX_VALUE / 10; i++)
		{
			if (i % 4 != 2)
			{
				list.add(new Integer[] {i});
			}
		}
		return list;
//		return Arrays.asList(new Object[][] { 
//				{ 3 }, { 5 }, { 7 },
//				{4}, {8}, {12},
//		
//		});
	}

	@Test
	public void test() {
		MagicSquare square = new MagicSquare();


		long sum = (long) size *  (long) ((long) size * (long) size + 1) / 2;
		int[][] squareResult = square.findMagicSquare(size);
		printMagicSquare(squareResult);
		for (int i = 0; i < size; i++) {
			int result = 0;
			for (int j = 0; j < size; j++) {
				result += squareResult[i][j];
			}
			Assert.assertEquals("magic Square size=" + size + "|row="+ i, sum, result);

		}
		for (int i = 0; i < size; i++) {
			int result = 0;
			for (int j = 0; j < size; j++) {
				result += squareResult[j][i];
			}
			Assert.assertEquals("magic Square size=" + size + "|col="+ i, sum, result);
		}
		int result = 0;
		for (int i = 0; i < size; i++) {
			result += squareResult[i][i];
		}
		Assert.assertEquals(sum, result);

		// backslash
		result = 0;
		for (int i = 0; i < size; i++) {
			result += squareResult[size - 1 - i][i];
		}
		Assert.assertEquals(sum, result);

		
	}

	private void printMagicSquare(int[][] squareResult) {
//		for (int i = 0; i < size; i++)
//		{
//			System.out.println(Arrays.toString(squareResult[i]));
//		}
	}
}
