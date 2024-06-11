import javax.swing.*;
import java.util.Random;

public class GuessTheNumber {

    public static  int maxattempt = 5;
    public static  int rounds = 3;
    public static int score = 0;

    public static void main(String[] args) {
        for (int i = 1;  i <= rounds; i++) {
            playround(i);
        }
        JOptionPane.showMessageDialog(null, "Game Over! Your final score is: " + score);
    }

    public static void playround(int round) {
        Random ran = new Random();
        int numberToGuess = ran.nextInt(100) + 1;
        int attempts = 0;
        boolean guessed = false;

        JOptionPane.showMessageDialog(null, "Round " + round + ": Guess the number between 1 and 100");

        while (attempts < maxattempt && !guessed) {
            String input = JOptionPane.showInputDialog("Enter your guess:");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Game cancelled.");
                System.exit(0);
            }

            int userGuess;
            try {
                userGuess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 100.");
                continue;
            }

            attempts++;
            if (userGuess == numberToGuess) {
                guessed = true;
                int points = maxattempt - attempts + 1;
                score += points;
                JOptionPane.showMessageDialog(null, "Correct! You guessed the number in " + attempts + " attempts. You earned " + points + " points.");
            }
            else if (userGuess < numberToGuess) {
                JOptionPane.showMessageDialog(null, "The number is higher than your guess.");
            }
            else {
                JOptionPane.showMessageDialog(null, "The number is lower than your guess.");
            }
        }

        if (!guessed) {
            JOptionPane.showMessageDialog(null, "Sorry, you've used all " + maxattempt + " attempts. The correct number was " + numberToGuess);
        }
    }
}
