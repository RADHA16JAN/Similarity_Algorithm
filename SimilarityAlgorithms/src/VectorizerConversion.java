import java.util.*;

public class VectorizerConversion {
    private Map<String, Integer> vocabulary;
    private int vocabularySize;
    public VectorizerConversion() {
        vocabulary = new HashMap<>();
        vocabularySize = 0;
    }

    // making a method to convert all words in to lower case and store
    public void buildVocabulary(List<String> documents) {
        for (String document : documents) {
            String[] words = document.toLowerCase().split("\\s+");
            for (String word : words) {
                if (!vocabulary.containsKey(word)) {
                    vocabulary.put(word, vocabularySize);
                    vocabularySize++;
                }
            }
        }
    }

    public double[] vectorize(String document) {
        double[] vector = new double[vocabularySize];
        String[] words = document.toLowerCase().split("\\s+");
        for (String word : words) {
            if (vocabulary.containsKey(word)) {
                int index = vocabulary.get(word);
                vector[index]++;
            }
        }

        // Normalizing the vector
        int documentLength = words.length;
        for (int i = 0; i < vector.length; i++) {
            vector[i] /= documentLength;
        }
        return vector;




}
}







