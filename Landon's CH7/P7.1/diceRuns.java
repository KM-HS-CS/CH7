import java.util.ArrayList;
public class diceRuns {
	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> rolls = new ArrayList<Integer>(); //type double because of nature of math.floor and math.random
		//rolls.add(0); //these are fillers for the first two values so I don't have to make a case in my ifs for the first value because of how i check previous values
		//rolls.add(0);
		for (int i = 0; i<20;i++) {
			rolls.add((int) ((Math.floor(Math.random()*6))+1));
		}
		boolean inRun = false;
		for (int roll = 0; roll<19;roll++) {
			if (inRun) {
				if (rolls.get(roll) != rolls.get(roll-1)) {
					System.out.printf(") ");
					inRun = false;
				}
			}
			if (!(inRun)) {
				if (rolls.get(roll) == rolls.get(roll+1)) {
					System.out.printf("( ");
					inRun = true;
				}
			}
			System.out.printf(rolls.get(roll) + " ");
		}
		System.out.printf(rolls.get(19) + " ");
		if (inRun) {
			System.out.printf(") ");
		}
	}
}