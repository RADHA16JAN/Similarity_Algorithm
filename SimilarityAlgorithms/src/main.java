import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Algorithms: (1-Cosine Similarity, 2-Euclidean Distance, 3-Manhattan Distance, 4-Jaccard Similarity, 5-Minkowski Distance)");
        String algos[] = {"cosine", "euclidean", "manhattan", "jaccard", "minkowski"};
        int num = sc.nextInt();
        Similarity sm = adapter.getSimilarityAlgo(algos[num-1]);
        sm.inputFilename1 = "D:\\Internship Assignment\\SimilarityAlgorithms\\Dummy_text2.txt";
        sm.inputFilename2 = "D:\\Internship Assignment\\SimilarityAlgorithms\\Dummy_text3.txt";
        System.out.println("Similarity: "+sm.findSimilarity());
    }
}