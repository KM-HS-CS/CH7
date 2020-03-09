import java.util.Scanner;

public class pokerCall {

	static pokerDeck newDeck = new pokerDeck();
	static String[] cards = {"0","0","0","0","0"};
	static int[] cardsNum = {0,0,0,0,0};
	static int[] royalFlush = {1,10,11,12,13};
	static String[] cardsSuit = {"0","0","0","0","0"};
	static int pairNum = 0;
	static boolean straight = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		cardsDrawn();
		for (String a : cards)
			{
			System.out.print("  " + a);
			
			}
		Scanner in = new Scanner(System.in);
		System.out.println();
		System.out.println("How many to replace: ");
		int replace = in.nextInt();
		int temp = 0;
		while (temp < replace) {
			System.out.println("Which card?");
			int cardReplace = in.nextInt();
			replace(cardReplace - 1);
			temp++;
		}
		for (String a : cards)
		{
		System.out.print("  " + a);
		
		}
		System.out.println();
		in.close();
		cardsSuited();
		cardsNumbered();
		cardsChecked();		
	}
	
	public static void replace(int cardReplace) {
		int numTemp = (int) (Math.random() * ((51 - 0) + 1)) + 0;
		cards[cardReplace] = newDeck.deck.get(numTemp);
		while (cardsDrawnCheck(cardReplace) == false) {
			numTemp = (int) (Math.random() * ((51 - 0) + 1)) + 0;
			cards[cardReplace] = newDeck.deck.get(numTemp);
		}
		
	}
	
	
	public static void cardsDrawn() {
		int num = 0;
		while (num < 5) {
			cards[num] = newDeck.deck.get(0);
			num ++;
		}
		num = 0;
		while (num < 5) {
			int numTemp = (int) (Math.random() * ((51 - 0) + 1)) + 0;
			cards[num] = newDeck.deck.get(numTemp);
			while (cardsDrawnCheck(num) == false) {
				numTemp = (int) (Math.random() * ((51 - 0) + 1)) + 0;
				cards[num] = newDeck.deck.get(numTemp);
			}
			num ++;
		}		
	}

	
	public static boolean cardsDrawnCheck(int num) {
		String check = cards[num];
		int checker = 0;
		for (String a : cards) {
			if (a.equals(check)) {
				checker++;
			}
			
		}
		if (checker > 1) {
			return false;
		}
		
		return true;
	}
	
	
	public static void cardsNumbered() {
		int num = 0;
		while (num < 5) {
			String cardTemp = cards[num];
			String cardTemper = cardTemp.substring(0, cardTemp.length() - 1);
			cardsNum[num] = Integer.parseInt(cardTemper);
			num++;
		}
	}
	
	public static void cardsSuited() {
		int num = 0;
		while (num < 5) {
			String cardTemp = cards[num];
			String cardTemper = cardTemp.substring(cardTemp.length()-1);
			cardsSuit[num] = cardTemper;
			num++;
		}
	}
	
	public static void cardsChecked() {
		int tempVar = 0;
		int num = 0;
		int numOfPairs = 0;
		
		while (num < 5)
		{
			tempVar = cardsNum[0];
			cardsNum[0] = cardsNum[num];
			cardsNum[num] = tempVar;
			if (cardsNum[0] == cardsNum[1] || cardsNum[0] == cardsNum[2] || cardsNum[0] == cardsNum[3] || cardsNum[0] == cardsNum[4]) {
				System.out.println("Pair " + cardsNum[0]);
				newDeck.tokenNum += 1;
				pairNum = cardsNum[0];
				if (pairCheck() == 3 || pairCheck() == 4) {
					
					if (pairCheck() == 4) {
						newDeck.tokenNum += 25;
						System.out.println("Four of a kind "  + cardsNum[0]);
					}
					else {
						newDeck.tokenNum += 3;
						System.out.println("Three of a kind "  + cardsNum[0]);
					}
					
				}
				
				else {
					numOfPairs++;
				}
				
				
			}
			num++;
		}
		if (numOfPairs != 0) {
			numOfPairs = numOfPairs/2;
		}
		if (numOfPairs == 3 || numOfPairs == 2) {
			if (numOfPairs == 3) {
				newDeck.tokenNum += 6;
				System.out.println("Full house");
			}
			else {
				newDeck.tokenNum += 2;
				System.out.println("Two pair");
			}
		}
		
		if (numOfPairs == 0) {
			cardsSort();
		}
		
		if (cardsSuit[0].equals(cardsSuit[1]) &&  cardsSuit[0].equals(cardsSuit[2]) &&  cardsSuit[0].equals(cardsSuit[4]) &&  cardsSuit[0].equals(cardsSuit[4])) {
			
			newDeck.tokenNum += 2;
			System.out.println("Flush");
			if (straight == true) {
				if (cardsNum == royalFlush) {
					newDeck.tokenNum += 250;
					System.out.println("Royal Flush");					
				}
				newDeck.tokenNum += 50;
				System.out.println("Straight Flush");
			}
			
			
			
		}
		if (straight == true) {
			newDeck.tokenNum += 4;
			System.out.println("Straight");
		}
		
	}
	
	public static void cardsSort() {
		int tempVar = 0;
		int num = 0;
		int test = 0;
		
		while (test < 1) {			
				if (num == 4) { 
					
				}
				else if (cardsNum[num] > cardsNum[num + 1]) {
					tempVar = cardsNum[num];
					cardsNum[num] = cardsNum[num + 1];
					cardsNum[num + 1] = tempVar;
				}
				
				if (cardsNum[0] + 1 == cardsNum[1] && cardsNum[0] + 2 == cardsNum[2] && cardsNum[0] + 3 == cardsNum[3] && cardsNum[0] + 4 == cardsNum[4]) {
					straight = true;
					test = 1;
				}
				else if (cardsNum[0] < cardsNum[1] && cardsNum[1] < cardsNum[2] && cardsNum[2] < cardsNum[3] && cardsNum[3] < cardsNum[4]) {
					test = 1;
				}
				num++;
				if (num > 4) {
					num = 0;
				}
		}
		
		
	}
	
	public static int pairCheck() {
		int pairsNum = 0;
		for (int a : cardsNum) {
			if (a == pairNum) {
				pairsNum ++;
			}
		}
		if (pairsNum == 4) {
			return 4;
		}
		else if (pairsNum == 3) {
			return 3;
		}
		
		return 0;
		
	}
	
}

