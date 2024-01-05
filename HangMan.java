import java.util.Arrays;
import java.util.Scanner;

/**
 * Randomly generates a word for the user to play hangman.
 * 
 * @author Nate Gould, S02559027
 * @version2023-8-27, CSC 1061, HangMan
 */
public class HangMan {

	public static void main(String[] args) {
		String[] words = {"word", "developer", "breakpoint" , "variable", "expression", "pumpkin", "navigate", "hangman"};
		boolean keepPlaying = true;
		Scanner in = new Scanner(System.in);
		
		while (keepPlaying){
			int rng = (int) (System.currentTimeMillis() % words.length);
			int misses = 0;
		
			//Create two char arrays, solution holds the answer EX	 {w, o, r, d}
			//guess is filled with '*' EX {*, *, *, *}
			char[] guess = new char[words[rng].length()];
			char[] solution = new char[words[rng].length()];
			for (int i = 0; i < words[rng].length(); i++) {
				solution[i] = words[rng].charAt(i);
				guess[i] = '*';
			}

			//Check if guess still has any * left
			while (new String(guess).indexOf('*') != -1) {
				printGuess(guess);
				char currentGuess = in.next().charAt(0);
				
				//Create a temp copy of guess to compare if guess changed later, indicating a correct guess
				char[] temp = Arrays.copyOf(guess, guess.length);
				
				//Check if guess already contains the users currentGuess
				if (Arrays.toString(guess).indexOf(currentGuess) != -1) {
					System.out.println("	" + currentGuess + " is already in the word");
					continue;
				}
				
				//Fill in correct guesses to guess[]
				for (int i = 0; i < guess.length; i++) {
					if (solution[i] == currentGuess) {
						guess[i] = currentGuess;
					}
				}
				
				//If guess didn't change at all, we know user did not guess a correct letter
				if (Arrays.equals(guess, temp)) {
					System.out.println("	" + currentGuess + " is not in the word");
					misses++;
				}
			}
			//If we made it here, print endgame message and prompt for new game
			System.out.println("The word is " + words[rng] + ". You missed " + misses + " time(s)");
			System.out.print("Do you want to guess another word? Enter y or n > ");
			if (in.next().charAt(0) == 'n') keepPlaying = false;
		}
		in.close();
	}
	
	public static void printGuess(char[] guess) {
		System.out.print("(Guess) Enter a letter in word ");
		for (int i = 0; i < guess.length; i++) {
			System.out.print(guess[i]);
		}
		System.out.print(" > ");
	}
	

}
