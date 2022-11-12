import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Game game = new Game();

        while (!game.gameEnded()) {
            System.out.println("You are guessing: " + game.getEncryptedMovie());
            System.out.println("You have guessed " + "(" + game.getFailedTries() + ") wrong letters:" + game.getWrongLetters());

            Scanner input = new Scanner(System.in);
            String guessedLetter = game.guessLetter();

            if (game.isRight(guessedLetter)) {
                game.rightGuess(guessedLetter);
            } else {
                game.wrongGuess(guessedLetter);
            }
        }
        if (game.hasWon())
        {
            System.out.println("YOU WIN!!");
        }
        else
        {
            System.out.println("GAME OVER!!");
            System.out.println("The movie title was " + game.movieToGuess);

        }
    }
}