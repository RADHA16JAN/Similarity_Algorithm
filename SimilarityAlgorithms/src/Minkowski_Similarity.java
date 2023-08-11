import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Minkowski_Similarity extends Similarity{

   class MinkowskiSimilarity{
    private double[] vector1;
    private double[] vector2;
    private int p;

    public MinkowskiSimilarity(double[] vector1, double[] vector2,int p) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.p = p;
    }

    //  make a calculateSimilarity method  which contains method how minkowski similarity works
    public double calculateDistance() {
        double distance = 0.0;

        for (int i = 0; i < vector1.length; i++) {
            distance += Math.pow(Math.abs(vector1[i] - vector2[i]), p);
        }
        return Math.pow(distance, 1.0 / p);
    }
}

    public double findSimilarity() {
        // Read input documents from text files using BufferedReader to read document
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

        // Vectorizing the input documents
        List<double[]> vectorizedDocuments = new ArrayList<>();
        for (String doc : documents) {
            vectorizedDocuments.add(vectorizer.vectorize(doc));
        }

        // Calculate Minkowski similarity between the two documents
        int doc1= 0; // Index of the first document in the vectorizedDocuments list
        int doc2 = 1; // Index of the second document in the vectorizedDocuments list
        double[] vector1 = vectorizedDocuments.get(doc1);
        double[] vector2 = vectorizedDocuments.get(doc2);


    // Initialising a variable
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of 'p': ");
        double p = sc.nextDouble();

        Minkowski_Similarity.MinkowskiSimilarity minkowskiSimilarity = new Minkowski_Similarity.MinkowskiSimilarity(vector1, vector2, (int) p);
        double similarity =minkowskiSimilarity.calculateDistance();

        // Printing the similarity
        System.out.println("Minkowski Similarity between Document 1 and Document 2 " +similarity);
        return similarity;
    }
}

