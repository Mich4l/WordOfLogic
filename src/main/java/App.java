import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        int count = 0; // count all characters in sentence.
        ArrayList list = new ArrayList(); // list of characters,value of word charakters and value of characters found in word
        int allCharactersCount = 0; // all count of the charakters we want to find
        String letterToCheck = "LOGIC"; // characters we want to find in sentens
        String sentence = "I love to work in global logic!.,@#$%^&*()!@"; // the sentence
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Input Your sentence: ");
        String sentence = scanner.nextLine();
        System.out.println("Input your word to check: ");
        String letterToCheck = scanner.nextLine(); */

        System.out.println("Your sentence= " + sentence);
        sentence = sentence.replaceAll("[^a-zA-Z0-9]", " "); // remove everything from sentence except [^a-zA-Z0-9]

        sentence = String.valueOf(sentence).toUpperCase();
        letterToCheck = String.valueOf(letterToCheck).toUpperCase();

        char[] charArrayFromLetterToCheck = new char[letterToCheck.length()];

        for (int i = 0; i < letterToCheck.length(); i++) {
            charArrayFromLetterToCheck[i] = letterToCheck.charAt(i);
        }

        for (int i = 0; i < sentence.length(); i++) { // count all characters in sentence
            if (sentence.charAt(i) != ' ')
                count++;
        }

        String[] words = sentence.split(" "); // divide sentence to single words
        for (String w : words) {
            int letterFoundInWord = 0;
            String chestForCharacters = ""; // this take character we find in word
            for (int j = 0; j < charArrayFromLetterToCheck.length; j++) {
                for (int i = 0; i < w.length(); i++) {
                    char chr = w.charAt(i);
                    if (charArrayFromLetterToCheck[j] == chr) {
                        allCharactersCount++;
                        letterFoundInWord++;
                        chestForCharacters = chestForCharacters + charArrayFromLetterToCheck[j];
                    }
                }
            }
            Counter character = new Counter(removeDuplicates(chestForCharacters), w.length(), letterFoundInWord);
            list.add(character);
        }
        Collections.sort(list);

        System.out.println("------------------------------");
        for (Object o : list) {
            System.out.print("{ (" + ((Counter) o).character.toLowerCase() + "), ");
            System.out.print(((Counter) o).wordSize + "} = ");
            System.out.format("%.2f", (double) ((Counter) o).getHowManyCharactersFind() / allCharactersCount);
            System.out.print(" (" + ((Counter) o).howManyCharactersFind + "/");
            System.out.println(allCharactersCount + ")");
        }
        System.out.print("TOTAL Frequency: ");
        System.out.format("%.2f", (double) allCharactersCount / count);
        System.out.println(" (" + allCharactersCount + "/" + count + ")");
        System.out.println("------------------------------");
    }

    public static String removeDuplicates(String str) {
        char[] chars = str.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        return sb.toString();
    }
}