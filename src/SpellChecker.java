import java.util.*;
import java.util.stream.Collectors;


public class SpellChecker {
    public static List<String> suggest(String word, List<String> dictionary, int maxSuggestions) {
        Map<String, Integer> distances = new HashMap<>();
        for (String dictWord : dictionary) {
            int distance = Levenshtein.compute(word.toLowerCase(), dictWord);
            distances.put(dictWord, distance);
        }

        return distances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(maxSuggestions)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<String> dictionary = DictionaryLoader.load("dictionary.txt");

        System.out.print("Enter a word: ");
        String input = sc.nextLine();

        List<String> suggestions = suggest(input, dictionary, 3);
        System.out.println("Did you mean: " + suggestions);
    }
}
