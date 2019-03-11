package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.LoggerFactory;

public class App {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(App.class);
    public static StringBuilder typedWordChars;
    public static StringBuilder wordChars;

    public static void main(String[] args) throws IOException {
        log.info("Bulls and cows. Start game");
        String typedWord;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        do 
        {
            WordHelper WordHelper = new WordHelper();
            String word = WordHelper.getWord();
            int tryCount = 0;
            
            System.out.println("Type any word:");
            do {
                typedWord = br.readLine();
                if (typedWord.toString().equals("/?")) {
                    System.out.println(word);
                    continue;
                }
                typedWordChars = new StringBuilder(typedWord);
                wordChars = new StringBuilder(word);
                tryCount++;

                int bullsCount = calculateBulls();
                int cowsCount = calculateCows();
                System.out.println("Cows: " + cowsCount + ". Bulls: " + bullsCount);
            } while(!typedWord.equals(word) && tryCount<10);

            System.out.println("Word was: " + word);

            if(tryCount == 10) {
                log.info("lose game");
                System.out.println("You lose!");
            }
            else {
                log.info("win game");
                System.out.println("Congratulations! You win!");
            }

            System.out.println("One more game? (Y/N)");
            typedWord = br.readLine();

        } while (typedWord.toString().equals("Y"));
    }

    public static int calculateBulls() {
        int bullsCount = 0;

        for (int index = 0; index < typedWordChars.length(); index++) {
            if (index < wordChars.length() && typedWordChars.charAt(index) == wordChars.charAt(index)) {
                bullsCount++;
                typedWordChars.deleteCharAt(index);
                wordChars.deleteCharAt(index);
                index--;
            }
        }

        return bullsCount;
    }

    public static int calculateCows() {
        int cowsCount = 0;
        for (int index = 0; index < typedWordChars.length(); index++) {
            for (int wordCharIndex = 0; wordCharIndex < wordChars.length(); wordCharIndex++) {
                if (typedWordChars.charAt(index) == wordChars.charAt(wordCharIndex)) {
                    cowsCount++;
                    typedWordChars.deleteCharAt(index);
                    wordChars.deleteCharAt(wordCharIndex);
                    index--;
                    break;
                }
            }
        }

        return cowsCount;
    }
}
