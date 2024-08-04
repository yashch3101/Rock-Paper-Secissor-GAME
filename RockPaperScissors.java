import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] CHOICES = {"Rock", "Paper", "Scissors"};
    private static final String[] SYMBOLS = {"✊", "✋", "✌"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Welcome to Rock-Paper-Scissors!");
            System.out.println("Enter your choice (1-3):");
            System.out.println("1. Rock ✊");
            System.out.println("2. Paper ✋");
            System.out.println("3. Scissors ✌");

            int playerChoice = scanner.nextInt();
            if (playerChoice < 1 || playerChoice > 3) {
                System.out.println("Invalid choice. Try again!");
                continue;
            }

            String playerChoiceString = CHOICES[playerChoice - 1];
            String playerChoiceSymbol = SYMBOLS[playerChoice - 1];

            int computerChoice = random.nextInt(3) + 1;
            String computerChoiceString = CHOICES[computerChoice - 1];
            String computerChoiceSymbol = SYMBOLS[computerChoice - 1];

            System.out.println("You chose: " + playerChoiceString + " " + playerChoiceSymbol);
            System.out.println("Computer chose: " + computerChoiceString + " " + computerChoiceSymbol);

            String result = determineWinner(playerChoiceString, computerChoiceString);
            System.out.println(result);

            System.out.println("Play again? (y/n)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}