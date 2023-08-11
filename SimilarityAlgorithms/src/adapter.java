
public  class adapter {
    public static Similarity getSimilarityAlgo(String input){
        Similarity obj;
        if(input.equalsIgnoreCase("cosine")){
            obj = new Cosine_Similarity();
        }
        else if(input.equalsIgnoreCase("euclidean")){
            obj = new Euclidean_Similarity();
        }
        else if(input.equalsIgnoreCase("manhattan")){
            obj = new Manhattan_Similarity();
        }
        else if(input.equalsIgnoreCase("jaccard")){
            obj = new Jaccard_Similarity();
        }
        else if(input.equalsIgnoreCase("minkowski")){
            obj = new Minkowski_Similarity();
        }
        else{
            obj = new Cosine_Similarity();
        }
        return  obj;
    }
}