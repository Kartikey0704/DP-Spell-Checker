import java.io.*;
import java.util.*;

public class DictionaryLoader {
    public static List<String> load(String filename) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            words.add(line.trim().toLowerCase());
        }
        br.close();
        return words;
    }
}
