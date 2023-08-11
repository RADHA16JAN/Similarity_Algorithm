import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cosine_Similarity extends Similarity {

    class CosineSimilarity {
        private double[] vectorA;
        private double[] vectorB;

        public CosineSimilarity(double[] vectorA, double[] vectorB) {
            this.vectorA = vectorA;
            this.vectorB = vectorB;
        }


        // make a calculateSimilarity method  which contains method how cosine similarity works
        public double calculateSimilarity() {
            if (vectorA.length != vectorB.length) {
                throw new IllegalArgumentException("Vector dimensions do not match");
            }

            double dotProduct = 0.0;
            double normA = 0.0;
            double normB = 0.0;

            for (int i = 0; i < vectorA.length; i++) {
                dotProduct += vectorA[i] * vectorB[i];
                normA += vectorA[i] * vectorA[i];
                normB += vectorB[i] * vectorB[i];
            }

            double similarity = dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
            return similarity;
        }
    }
    public double findSimilarity() {
        // Reading input documents from text files using bufferReader function
        List<String> documents = new ArrayList<>();
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("Dummy_text2.txt"));
            String line1;
            while ((line1 = reader1.readLine()) != null) {
                documents.add(line1);
            }
            reader1.close();

            BufferedReader reader2 = new BufferedReader(new FileReader("Dummy_text3.txt"));
            String line2;
            while ((line2 = reader2.readLine()) != null) {
                documents.add(line2);
            }
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        // Creating the document vectorizer
        VectorizerConversion vectorizer = new VectorizerConversion();
        vectorizer.buildVocabulary(documents);

        // Vectorizing the input documents using arraylist
        List<double[]> vectorizedDocuments = new ArrayList<>();
        for (String doc : documents) {
            vectorizedDocuments.add(vectorizer.vectorize(doc));
        }

        // Calculate cosine similarity between the two documents
        int doc1 = 0; // Index of the first document in the vectorizedDocuments list
        int doc2 = 1; // Index of the second document in the vectorizedDocuments list
        double[] vector1 = vectorizedDocuments.get(doc1);
        double[] vector2 = vectorizedDocuments.get(doc2);

        CosineSimilarity cosineSimilarity = new CosineSimilarity(vector1, vector2);
        double similarity = cosineSimilarity.calculateSimilarity();

        // Printing the similarity
        System.out.println("Cosine Similarity between Document 1 and Document 2: " + similarity);
        return similarity;
    }
}
