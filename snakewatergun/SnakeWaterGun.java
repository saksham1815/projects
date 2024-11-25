import java.util.Random;
import java.util.Scanner;

public class SnakeWaterGun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Snake Water Gun game!");

        int playerScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.println("\nCurrent Score:");
            System.out.println("Player: " + playerScore + "  Computer: " + computerScore);

            System.out.print("\nEnter your choice (snake, water, or gun): ");
            String playerChoice = scanner.next().toLowerCase();

            if (!playerChoice.equals("snake") && !playerChoice.equals("water") && !playerChoice.equals("gun")) {
                System.out.println("Invalid input! Please enter snake, water, or gun.");
                continue;
            }

            int computer = random.nextInt(3); // 0 for snake, 1 for water, 2 for gun

            String computerChoice;
            switch (computer) {
                case 0:
                    computerChoice = "snake";
                    break;
                case 1:
                    computerChoice = "water";
                    break;
                default:
                    computerChoice = "gun";
            }

            System.out.println("Computer's choice: " + computerChoice);

            String roundResult = "";
            if (playerChoice.equals(computerChoice)) {
                roundResult = "It's a tie!";
            } else if ((playerChoice.equals("snake") && computerChoice.equals("water")) ||
                    (playerChoice.equals("water") && computerChoice.equals("gun")) ||
                    (playerChoice.equals("gun") && computerChoice.equals("snake"))) {
                roundResult = "You win!";
                playerScore++;
            } else {
                roundResult = "Computer wins!";
                computerScore++;
            }

            System.out.println(roundResult);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nFinal Score:");
        System.out.println("Player: " + playerScore + "  Computer: " + computerScore);
        System.out.println("\nThanks for playing Snake Water Gun game!");
        scanner.close();
    }
}
