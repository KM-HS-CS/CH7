import java.util.Scanner;


public class ticTacToe {

	public static int turnCounter = 0;
	static String[][] board =
		{
				{"#", "#", "#"},
				{"#", "#", "#"},
				{"#", "#", "#"}
		};
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		
		
		while (checkWinner() == false) {		
			
			for (int i = 0; i < board.length; i++)
			{
				for (int j = 0; j < board[0].length; j++)
				{
					System.out.print(board[i][j] + "  " );
				}
				System.out.println();
			}
			
			if (turnCounter % 2 == 0) {
				
				System.out.println("Pick a Column");
				int row = in.nextInt();
				System.out.println("Pick a Row");
				int column = in.nextInt();
				if (board[column - 1][row - 1] == "X" || board[column - 1][row - 1] == "O") {
				System.out.println("Not Available");
				}
				else {
					board[column - 1][row - 1] = "O";
				}
				
			}
			else {
				System.out.println("Pick a Column");
				int row = in.nextInt();
				System.out.println("Pick a Row");
				int column = in.nextInt();
				if (board[column - 1][row - 1] == "X" || board[column - 1][row - 1] == "O") {
				System.out.println("Not Available");
				}
				else {
					board[column - 1][row - 1] = "X";
				}
			}
			
			in.close();
			
	}
		
		
	}
	
	
	public static boolean checkWinner() {
		int j = 0;
		int i = 0;
		for (int b = 0; b < 3; b ++) {
				
				if (board[i][j].equals(board[i][j+1])) {
					if (board[i][j+1].equals(board[i][j+2])) {
						if (board[i][j] == "X") {
							System.out.println("X Wins");
							return true;
						}
						else if (board[i][j] == "O"){
							System.out.println("O Wins");
							return true;
						}
						else {
							break;
						}
					}
					if (board[i][j].equals(board[i+1][j])) {
						if (board[i + 1][j].equals(board[i + 2][j])) {
							if (board[i][j] == "X") {
								System.out.println("X Wins");
								return true;
							}
							else if (board[i][j] == "O"){
								System.out.println("O Wins");
								return true;
							}
							else {
								break;
							}
						}
						
				}
			
			}}
		
		if (board[0][0].equals(board[1][1])) {
			if (board[1][1].equals(board[2][2])) {
					if (board[0][0] == "X") {
						System.out.println("X Wins");
						return true;
					}
					else if (board[0][0] == "O"){
						System.out.println("O Wins");
						return true;
					}
					else {
						return false;
					}
				}}
			if (board[0][2].equals(board[1][2])) {
				if (board[1][2].equals(board[2][0])) {
						if (board[0][0] == "X") {
							System.out.println("X Wins");
							return true;
						}
						else if (board[0][0] == "O"){
							System.out.println("O Wins");
							return true;
						}
						else {
							return false;
						}
					
				}}
		
		return false;
	
		}}
		
	
	
	
		
