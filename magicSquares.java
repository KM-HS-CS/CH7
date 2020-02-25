
import java.util.Scanner;

public class magicSquares {
	
	static int[][] squares = new int[4][4];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int num = 0;
		while (num < 16) {
			for (int i = 0; i < squares.length; i++)
			{
				for (int j = 0; j < squares[0].length; j++)
				{
					System.out.println("Insert a number: ");
					int number = in.nextInt();
					squares[i][j] = number;
					num ++;
				}
				System.out.println();
			}

		}
		
		for (int i = 0; i < squares.length; i++)
		{
			for (int j = 0; j < squares[0].length; j++)
			{
				System.out.printf("%8d", squares[i][j]);
			}
			System.out.println();
		}
	
	System.out.println("Sum of Rows: " + );
	System.out.println("Sum of Collums: " + );
		
		
		
	in.close();

	}

}
