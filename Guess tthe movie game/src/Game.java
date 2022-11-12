import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Scanner;

public class Game {
    public String movieToGuess;
    String encryptedMovie;
    int failedTries;

    String rightLetters;
    String wrongLetters;


       Game() throws FileNotFoundException {
        File moviesList = new File("movies.txt");
        Scanner filescanner = new Scanner(moviesList);
        int movieNum = (int) (Math.random() * 100) % 25;
        int i = 0; String s = null;
        while (i <= movieNum)
        {
            movieToGuess = filescanner.nextLine();
            i++;
        }
        encryptedMovie = movieToGuess.replaceAll("[a-zA-Z]", "_");
        failedTries = 0;
        rightLetters ="";
        wrongLetters ="";
    }

    boolean isRight(String c)
    {
        return movieToGuess.contains(c.toLowerCase());
    }

    void rightGuess(String c)
    {
        rightLetters += c.toLowerCase();
        encryptedMovie = movieToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters +"]]", "_");
    }
    void wrongGuess(String c)
    {
        wrongLetters += " " + c.toLowerCase();
        failedTries++;
    }
    int getFailedTries()
    {
        return failedTries;
    }
    String getEncryptedMovie()
    {
        return encryptedMovie;
    }

    String getMovieToGuess()
    {
        return movieToGuess;
    }
    String getWrongLetters()
    {
        return wrongLetters;
    }

    boolean gameEnded()
    {
        return (encryptedMovie.toLowerCase() == movieToGuess || failedTries == 10);
    }


    String guessLetter()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess: ");
        String c  = scanner.nextLine();
        if (wrongLetters.contains(c.toLowerCase()) || rightLetters.contains(c.toLowerCase())) {
            System.out.println("You have guessed this letter before");
            return guessLetter();
        }
        else if (!c.matches("[a-z]"))
        {
            System.out.println("This is not a letter");
            return guessLetter();
        }
        else
            return c;
    }
    boolean hasWon()
    {
        if (encryptedMovie.toLowerCase() == movieToGuess)
            return true;
        else
            return false;
    }

}
