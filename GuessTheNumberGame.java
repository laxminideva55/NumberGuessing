import java.util.*;
import javax.swing.JOptionPane;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int round = 1;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");

        while (true) {
            int targetNumber = generateRandomNumber(lowerBound, upperBound);
            int attempts = 0;

            JOptionPane.showMessageDialog(null, "Round " + round + ": Try to guess the number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                int userGuess = getUserGuess();

                if (userGuess == targetNumber) {
                    int roundScore = maxAttempts - attempts;
                    score += roundScore;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + (attempts + 1) + " attempts.\nRound Score: " + roundScore + "\nTotal Score: " + score);
                    break;
                } else if (userGuess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Try a higher number. Remaining attempts: " + (maxAttempts - attempts - 1));
                } else {
                    JOptionPane.showMessageDialog(null, "Try a lower number. Remaining attempts: " + (maxAttempts - attempts - 1));
                }

                attempts++;
            }

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again", JOptionPane.YES_NO_OPTION);
            if (choice != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Game Over. Your final score: " + score);
                break;
            }

            round++;
        }
    }

    public static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public static int getUserGuess() {
        while (true) {
            try {
                String guessStr = JOptionPane.showInputDialog("Enter your guess:");
                int guess = Integer.parseInt(guessStr);
                return guess;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
    }
}