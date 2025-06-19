import java.io.*;
import java.util.*;

public class WordManager {
    private static final String WORDS_FILE = "words.txt";

    public static String pickRandomWord() {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(WORDS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) words.add(line.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("단어 파일 읽기 오류: " + e.getMessage());
        }
        if (words.isEmpty()) return "DEFAULT";
        return words.get(new Random().nextInt(words.size()));
    }
}