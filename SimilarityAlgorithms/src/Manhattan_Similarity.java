import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manhattan_Similarity extends Similarity{
    class ManhattanSimilarity{
    private double[] vector1;
    private double[] vector2;

    public ManhattanSimilarity(double[] vector1, double[] vector2) {
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    //  make a calculateSimilarity method  which contains method how manhattan similarity works
    public double calculateSimilarity() {
        double distance = 0.0;

        for (int i = 0; i < vector1.length; i++) {
            distance += Math.abs(vector1[i] - vector2[i]);
        }

        return distance;
    }
}

    public double findSimilarity() {
        // Read input documents from text files using BufferReader to read document
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

        // Create the document vectorizer
        VectorizerConversion vectorizer = new VectorizerConversion();
        vectorizer.buildVocabulary(documents);

        // Vectorize the input documents
        List<double[]> vectorizedDocuments = new ArrayList<>();
        for (String doc : documents) {
            vectorizedDocuments.add(vectorizer.vectorize(doc));
        }

        // Calculate Manhattan similarity between the two documents
        int doc1 = 0; // Index of the first document in the vectorizedDocuments list
        int doc2 = 1; // Index of the second document in the vectorizedDocuments list
        double[] vector1 = vectorizedDocuments.get(doc1);
        double[] vector2 = vectorizedDocuments.get(doc2);

        Manhattan_Similarity. ManhattanSimilarity  manhattanSimilarity = new  Manhattan_Similarity. ManhattanSimilarity (vector1, vector2);
        double similarity = manhattanSimilarity.calculateSimilarity();

        // Printing the similarity
        System.out.println("Manhattan Similarity between Document 1 and Document 2 " +similarity);
        return similarity;
    }
}


