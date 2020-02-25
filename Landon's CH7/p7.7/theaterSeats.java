import java.util.Scanner;
public class theaterSeats {
	static void print2d(int[][] list) {
		for (int[] i: list) {
			for (int j: i) {
				System.out.printf(j + "  ");
			}
			System.out.printf("%n");
		}
	}
	
	public static void main(String[] args) { //Yes the fastest way to make the array was to hand transcribe
		int[][] seats = {
				{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
				{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
				{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
				{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
				{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
				{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
				{20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
				{20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
				{30, 40, 50, 50, 50, 50, 50, 50, 40, 30}
		};
		Scanner in = new Scanner(System.in); //idk why this causes an issue when i close it at the end
		int seat = 90;
		while (seat > 0) {
			System.out.printf("%n Seats left is: " + seat + "%n %n");
			print2d(seats);
			System.out.printf("%n Choose a seat by: %n 1. Seat %n 2. Price %n 3. quit %n");
			int value = in.nextInt();
			if (value == 1) {
				System.out.printf("Please choose a row (1-10): ");
				value = in.nextInt() - 1; //-1 because of index values
				if (!(-1 < value && value < 10)) { //if it's not a valid value
					System.out.printf("%n Error, please try again %n");
				} else {
					System.out.printf("Please choose a column (1-9): ");
					int valuex = in.nextInt() - 1; //-1 because of index values
					if (!(-1<value && value<9)) {
						System.out.printf("%n Error, please try again %n");
					} else {
						if (seats[value][valuex] == 99) {
							System.out.printf("Sorry, that seat is taken");
						} else {
							System.out.printf("Thank you for purchasing seat %d"+ " , %d for $%d", value, valuex, seats[value][valuex]);
							seats[value][valuex] = 99;
							seat--;
						}
					}
				}
			} else if (value == 2) {
				boolean found = false; //used at end to say if there is a seat with given price
				
				System.out.printf("%n Please give a price that is a multiple of 10 from 10 to 50: ");
				value = in.nextInt();
				if (value == 10 || value == 20 || value == 30 || value == 40 || value == 50 ) {
					int x = -1;
					int y = -1;
					for (int i=0;i<=8;i++) {
						for (int j=0;j<=9;j++) {
							if (seats[i][j]==value) {
								found = true;
								x = i;
								y = j;
							}
						}
					}
					if (found==true) {
						System.out.printf("Thank you for purchasing seat %d"+ " , %d for $%d", x, y, value);
						seat--;
					}
					
				} else {
					System.out.printf("%n Error, please try again %n");	
				}
			} else if (value == 3) {
				System.out.println("Have a good rest of your day!!!");
				return;
			}
			
		}
		in.close();
	}
}
