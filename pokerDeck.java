import java.util.ArrayList;

public class pokerDeck{
	ArrayList<String> deck = new ArrayList<String>();
	public int tokenNum = 0;
	public pokerDeck() {
		
		
		int num = 0;
		String suit = "S";
		int suitNum = 0;
		int value = 1;
		while (num < 52) {
			while (suitNum < 4) {
				while (value < 14) {
					deck.add(value + suit);
					value++;
					num++;
				}
				suitNum++;
				if (suitNum == 1) {
					value = 1;
					suit = "H";
				}
				else if (suitNum == 2) {
					value = 1;
					suit = "D";
				}
				else {
					value = 1;
					suit = "C";
				}
				
			}
		}
		
		
		
		
		
	}
	
	
}
