import java.util.*;

public class HangmanGame {
    private final String wordToGuess;
    private final Set<Character> correctGuesses = new HashSet<>();
    private final Set<Character> wrongGuesses = new HashSet<>();
    private final int maxTries = 6;

    public HangmanGame(String word) {
        this.wordToGuess = word.toUpperCase();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public boolean isAlreadyGuessed(char c) {
        return correctGuesses.contains(c) || wrongGuesses.contains(c);
    }

    public boolean guess(char c) {
        c = Character.toUpperCase(c);
        if (wordToGuess.indexOf(c) >= 0) {
            correctGuesses.add(c);
            return true;
        } else {
            wrongGuesses.add(c);
            return false;
        }
    }

    public int getWrongGuessCount() {
        return wrongGuesses.size();
    }

    public Set<Character> getWrongGuesses() {
        return wrongGuesses;
    }

    public String getCurrentWordState() {
        StringBuilder sb = new StringBuilder();
        for (char c : wordToGuess.toCharArray()) {
            sb.append(correctGuesses.contains(c) ? c : '_').append(' ');
        }
        return sb.toString().trim();
    }

    public boolean isWon() {
        for (char c : wordToGuess.toCharArray()) {
            if (!correctGuesses.contains(c)) return false;
        }
        return true;
    }

    public boolean isLost() {
        return wrongGuesses.size() >= maxTries;
    }

    public int getRemainingTries() {
        return maxTries - wrongGuesses.size();
    }
}