import java.util.Scanner;

//import com.sun.javafx.css.CalculatedValue;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int score;

	public static void main(String[] args) {
		
		int[] bVals = input();
		System.out.println("Rounds: " + bVals[0]);
		System.out.print("Throws:");
		for (int i = 1; i < bVals.length; i++) {
			System.out.print(" " + bVals[i]);
		}
		System.out.println();
		int[] scoreRound = calculateScore(bVals);
		
		
		
		output(scoreRound);
		sc.close();
	}
	private static int[] input() {
		System.out.println("Input: <Number of Rounds>:<Throw1>,<Throw2>,<Throw3>, …");
		System.out.print("Input: ");
		String input = sc.next();
		int[] val = splitInput(input);
		return val;
	}
	//bVals[0] = Number of Rounds; bVals[1...] = throws
	private static int[] splitInput(String input) {
		String[] parts = input.split(":");
		int numOfRounds = Integer.parseInt(parts[0]);
		String[] t = parts[1].split(",");
		int[] bVals = new int[t.length + 1];
		bVals[0] = numOfRounds;
		for (int i = 1; i <= t.length; i++) {
			bVals[i] = Integer.parseInt(t[i - 1]);
		}
		return bVals;
	}

	private static void output(int[] scoreRound) {
		System.out.println("Output:");
		for (int i = 0; i < scoreRound.length; i++) {
			System.out.print(scoreRound[i]);
			if (i != scoreRound.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
		
	}
	
	private static int[] calculateScore(int[] bVals) {
		int[] scoreRound = new int[bVals[0]];
		for(int i = 0; i < bVals[0]; i++) {	
			boolean isStrike = bVals[2*i+1] == 10;
			boolean isSpare = (bVals[2 * i + 1] + bVals[2 * i + 2]) == 10;
			if (isStrike) {
				score = score + bVals[2 * i + 1] + bVals[2 * i + 2] + bVals[2 * i + 3] + bVals[2 * i + 4];
				scoreRound[i] = score;
			} else if (isSpare) {
				score = score + bVals[2 * i + 1] + bVals[2 * i + 2] + bVals[2 * i + 3];
				scoreRound[i] = score;
			} else {
				score = score + bVals[2 * i + 1] + bVals[2 * i + 2]; 	//des für kein strike
				scoreRound[i] = score;
			}
		}
		return scoreRound;
	}
}
