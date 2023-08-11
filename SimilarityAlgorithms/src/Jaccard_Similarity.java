//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//
//public class Jaccard_Similarity extends Similarity {
//    class JaccardSimilarity{
//    public static Vector<String> vectorA;
//    public static Vector<String> vectorB;
//
//        public JaccardSimilarity(double[] vectorA, double[] vectorB) {
//
//        }
//
//
//        // Method to calculate Jaccard similarity between two sets represented as vectors
//        public static double calculateJaccardSimilarity() {
//            if (vectorA.isEmpty() || vectorB.isEmpty()) {
//                return 0.0; // If any of the vectors is empty, similarity is 0
//            }
//
//            // Convert vectors to sets for easier intersection and union calculations
//            Set<String> setA = new HashSet<>(vectorA);
//            Set<String> setB = new HashSet<>(vectorB);
//
//            // Calculate intersection of the sets
//            Set<String> intersection = new HashSet<>(setA);
//            intersection.retainAll(setB);
//
//            // Calculate union of the sets
//            Set<String> union = new HashSet<>(setA);
//            union.addAll(setB);
//
//            // Calculate Jaccard similarity
//            return (double) intersection.size() / union.size();
//        }
//
////    public JaccardSimilarity(Vector<String> vector1, Vector<String> vector2) {
////        this.vector1=vector1;
////        this.vector2=vector2;
////    }
////
////    public double calculateSimilarity() {
////
////        Set<String> union = new HashSet<>(vector1);
////        union.addAll(vector2);
////
////        Set<String> intersection = new HashSet<>(vector1);
////        intersection.retainAll(vector2);
////
////        if (union.isEmpty()) {
////            return 0.0;
////        }
////
////        return (double) intersection.size() / union.size();
//
//
//
//
////        ArrayList<Double> vector1 = new ArrayList<>();
////        ArrayList<Double> vector2 = new ArrayList<>();
////       // ConverttoVector(inputFilename1, inputFilename2, vector1, vector2);
////
////        int v1 = vector1.size();
////        int v2 = vector2.size();
////
////        int i=0, j=0;
////        int similar_elements = 0;
////        while(i<v1 && j<v2){
////            if((vector1.get(i++) >=1 )&& (vector2.get(j++) >=1)){
////                similar_elements++;
////            }
////        }
////        int total_unique_elements = v1+v2-similar_elements;
////
////        double jaccard_ratio = similar_elements/total_unique_elements;
////
////        return jaccard_ratio;
////   }
//}
//
//    public double findSimilarity() {
//        // Read input documents from text files
//        List<String> documents = new ArrayList<>();
//        try {
//            BufferedReader reader1 = new BufferedReader(new FileReader("Dummy_text2.txt"));
//            String line1;
//            while ((line1 = reader1.readLine()) != null) {
//                documents.add(line1);
//            }
//            reader1.close();
//
//            BufferedReader reader2 = new BufferedReader(new FileReader("Dummy_text3.txt"));
//            String line2;
//            while ((line2 = reader2.readLine()) != null) {
//                documents.add(line2);
//            }
//            reader2.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return 0;
//        }
//
//        // Create the document vectorizer
//        VectorizerConversion vectorizer = new VectorizerConversion();
//        vectorizer.buildVocabulary(documents);
//
//        // Vectorize the input documents
//        List<double[]> vectorizedDocuments = new ArrayList<>();
//        for (String doc : documents) {
//            vectorizedDocuments.add(vectorizer.vectorize(doc));
//        }
//
//        //  Vector<String>Calculate cosine similarity between the two documents
//        int doc1Index = 0; // Index of the first document in the vectorizedDocuments list
//        int doc2Index = 1; // Index of the second document in the vectorizedDocuments list
//        double[] vectorA = vectorizedDocuments.get(doc1Index);
//        double[] vectorB = vectorizedDocuments.get(doc2Index);
//
//        Jaccard_Similarity.JaccardSimilarity jaccardSimilarity = new Jaccard_Similarity.JaccardSimilarity(vectorA,vectorB);
//        double similarity =jaccardSimilarity.calculateJaccardSimilarity();
//
//        // Print the similarity score
//        System.out.println("Jaccard Similarity between Document 1 and Document 2 " +similarity);
//        return similarity;
//    }
//}


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Jaccard_Similarity extends Similarity {

    class JaccardSimilarity {
        private Set<String> set1;
        private Set<String> set2;

        public JaccardSimilarity(Set<String> set1, Set<String> set2) {
            this.set1 = set1;
            this.set2 = set2;
        }

        // // make a calculateSimilarity method  which contains method how jaccard similarity works
        public double calculateSimilarity() {
            Set<String> union = new HashSet<>(set1);
            union.addAll(set2);

            Set<String> intersection = new HashSet<>(set1);
            intersection.retainAll(set2);

            if (union.isEmpty()) {
                return 0.0;
            }

            return (double) intersection.size() / union.size();
        }
    }

    public double findSimilarity() {
        // Reading input documents from text files using BufferReader to read
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

//         Calculate Jaccard similarity between the two documents
        int doc1= 0; // Index of the first document in the vectorizedDocuments list
        int doc2 = 1; // Index of the second document in the vectorizedDocuments list
        double[] vectorA = vectorizedDocuments.get(doc1);
        double[] vectorB = vectorizedDocuments.get(doc2);

//        double[] doc1Vector = vectorizedDocuments.get(0);
//        double[] doc2Vector = vectorizedDocuments.get(1);

        JaccardSimilarity jaccardSimilarity = new JaccardSimilarity(new HashSet<>(), new HashSet<>());
        double similarity = jaccardSimilarity.calculateSimilarity();

        // Print the similarity
        System.out.println("Jaccard Similarity between Document 1 and Document 2: " + similarity);
        return similarity;
    }
}
